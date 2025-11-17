package level2.model;
import level2.interfaces.Phone;

public class USAPhone implements Phone {

    String number;

    public USAPhone(String number) {
        this.number = number;
    }

    public String getFormatPhone(){
        String USAFormatPhone = "+1" + number;
        return USAFormatPhone;
    }


}
