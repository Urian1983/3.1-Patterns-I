package level2.model;

import level2.interfaces.Address;
import level2.interfaces.ContactFactory;
import level2.interfaces.Phone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactBookTest {

   @Test
   void testSpainFactoryContactCreation() {

           ContactFactory factory = new SpainFactory();
           ContactBook book = new ContactBook(factory);

           book.addAddress("Calle Mayor", "10", "Madrid", "28013");
           book.addPhone("612345678");

           Address address = book.getAddressList().get(0);

           assertEquals(
                   "calle: Calle Mayor, numero: 10, ciudad: Madrid, codigo postal: 28013",
                   address.getFormatAddress()
           );

           Phone phone = book.getPhoneList().get(0);

           assertEquals(
                   "+34612345678",
                   phone.getFormatPhone()
           );
   }

   @Test
   void testUSAFactoryContactCreation() {

       ContactFactory factory = new USAFactory();
       ContactBook book = new ContactBook(factory);

       book.addAddress("Main St", "10", "New York", "10001");
       book.addPhone("5551234567");

       Address address = book.getAddressList().get(0);

       assertEquals(
               "street: Main St, number: 10, city: New York, postal code: 10001",
               address.getFormatAddress()
       );

       Phone phone = book.getPhoneList().get(0);

       assertEquals(
               "+15551234567",
               phone.getFormatPhone()
       );
   }
}