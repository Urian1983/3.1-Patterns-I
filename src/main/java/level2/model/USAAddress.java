package level2.model;

import level2.interfaces.Address;

public class USAAddress implements Address {

    String street;
    String number;
    String city;
    String postalCode;

    public USAAddress(String street, String number, String city, String postalCode) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.postalCode = postalCode;
    }

    @Override
    public String getFormatAddress(){
        return "street: " +street +", number: " +number +", city: " +city+ ", postal code: " +postalCode;
    }
}
