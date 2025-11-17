package level2.view;

import level2.interfaces.ContactFactory;
import level2.model.ContactBook;
import level2.model.SpainFactory;
import level2.model.USAFactory;

import java.util.Scanner;

public class ContactBookView {
    private Scanner scanner = new Scanner(System.in);
    private ContactBook contactBook;

    public void run() {

        contactBook = new ContactBook(chooseFactory());

        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Contact Book Menu ---");
            System.out.println("1. Add address");
            System.out.println("2. Add phone");
            System.out.println("3. Show all contacts");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // limpiar salto línea

            switch (option) {
                case 1:
                    addAddress();
                    break;
                case 2:
                    addPhone();
                    break;
                case 3:
                    contactBook.printContacts();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        System.out.println("Exiting...");
    }

    private ContactFactory chooseFactory() {
        System.out.println("=== International Contact Book ===");
        System.out.println("Choose region:");
        System.out.println("1. Spain");
        System.out.println("2. USA");
        System.out.print("Option: ");

        int option = scanner.nextInt();
        scanner.nextLine(); // limpiar salto

        switch (option) {
            case 1:
                return new SpainFactory();
            case 2:
                return new USAFactory();
            default:
                System.out.println("Invalid option. Defaulting to Spain");
                return new SpainFactory();
        }
    }

    private void addAddress() {
        System.out.print("Street: ");
        String street = scanner.nextLine();

        System.out.print("Number: ");
        String number = scanner.nextLine();

        System.out.print("City: ");
        String city = scanner.nextLine();

        System.out.print("Postal Code: ");
        String postalCode = scanner.nextLine();

        contactBook.addAddress(street, number, city, postalCode);

        System.out.println("Address added!");
    }

    private void addPhone() {
        System.out.print("Phone number: ");
        String number = scanner.nextLine();

        contactBook.addPhone(number);

        System.out.println("Phone added!");
    }
}



