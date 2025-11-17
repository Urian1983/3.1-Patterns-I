package level2.model;

import level2.interfaces.Address;

public class SpainAddress implements Address {
    String street;
    String number;
    String city;
    String postalCode;

    public SpainAddress(String street, String number, String city, String postalCode) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.postalCode = postalCode;
    }

    @Override
    public String getFormatAddress(){
        return "calle: " +street +", numero: " +number +", ciudad: " +city+ ", codigo postal: " +postalCode;
    }
}
