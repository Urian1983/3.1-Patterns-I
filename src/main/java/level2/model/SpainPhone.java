package level2.model;

import level2.interfaces.Phone;

public class SpainPhone implements Phone {
    String number;

    public SpainPhone(String number) {
        this.number = number;
    }

    public String getFormatPhone(){
        String USAFormatPhone = "+34" + number;
        return USAFormatPhone;
    }
}
