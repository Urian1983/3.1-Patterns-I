package level2.model;

import level2.interfaces.Address;
import level2.interfaces.ContactFactory;
import level2.interfaces.Phone;

import java.util.ArrayList;
import java.util.List;

public class ContactBook {

    private List<Address> addressList= new ArrayList<Address>();
    private List<Phone> phoneList = new ArrayList<Phone>();
    private ContactFactory contactFactory;

    public List<Address> getAddressList() {
        return addressList;
    }

    public List<Phone> getPhoneList() {
        return phoneList;
    }

    public ContactBook(ContactFactory contactFactory) {
        this.contactFactory = contactFactory;
    }

    public void addAddress(String street, String number, String city, String postalCode){
        addressList.add(contactFactory.createAddress(street,number,city,postalCode));
    }

    public void addPhone(String number){
        phoneList.add(contactFactory.createPhone(number));

    }

    public void printContacts(){
        System.out.println("Addresses: ");
        addressList.forEach(a -> System.out.println(a.getFormatAddress()));

        System.out.println("Phones: ");
        phoneList.forEach(a -> System.out.println(a.getFormatPhone()));
    }
}
