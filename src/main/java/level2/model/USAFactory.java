package level2.model;

import level2.interfaces.Address;
import level2.interfaces.ContactFactory;
import level2.interfaces.Phone;

public class USAFactory implements ContactFactory {

    @Override
    public Address createAddress(String street, String number, String city, String postalCode){
        return new USAAddress(street,number,city,postalCode);
    }

    @Override
    public Phone createPhone(String number){
        return new USAPhone(number);
    }
}
