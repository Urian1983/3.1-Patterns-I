package level2.interfaces;

public interface ContactFactory {
    Address createAddress(String street, String number, String city, String postalCode);
    Phone createPhone (String Phone);
}
