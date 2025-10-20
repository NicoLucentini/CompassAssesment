import org.junit.jupiter.api.Test;
import org.lucentininicolas.Contact;

import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {
    @Test
    public void twoEqualsContactShouldReturn_221(){
        Contact c1 = new Contact();
        c1.setAddress("address");
        c1.setFirstName("name");
        c1.setLastName("last");
        c1.setZipCode("123");
        c1.setEmailAddress("email@test.com");

        Contact c2 = new Contact();
        c2.setAddress("address");
        c2.setFirstName("name");
        c2.setLastName("last");
        c2.setZipCode("123");
        c2.setEmailAddress("email@test.com");

        assertEquals(221.0, c1.compare(c2));

    }
    @Test
    public void twoDifferentsContactShouldNotBeSimilar(){
        Contact c1 = new Contact();
        c1.setContactId(1000);
        c1.setAddress("449-6990 Tellus. Rd.");
        c1.setFirstName("C");
        c1.setLastName("F");
        c1.setZipCode("");
        c1.setEmailAddress("mollis.lectus.pede@outlook.net");


        Contact c3 = new Contact();
        c3.setContactId(1002);
        c3.setAddress("");
        c3.setFirstName("Ciara");
        c3.setLastName("F");
        c3.setZipCode("39746");
        c3.setEmailAddress("non.lacinia.at@zoho.ca");

        assertEquals("LOW", c1.isSimilar(c3));
    }
    @Test
    public void twoMediumContactShouldReturnMedium(){
        Contact c1 = new Contact();
        c1.setAddress("address");
        c1.setFirstName("name");
        c1.setLastName("last");
        c1.setZipCode("123");
        c1.setEmailAddress("email@test.com");

        Contact c2 = new Contact();
        c2.setAddress("mansilla");
        c2.setFirstName("nam");
        c2.setLastName("lastName");
        c2.setZipCode("123");
        c2.setEmailAddress("emai@gmail.com");

        assertEquals("MEDIUM", c1.isSimilar(c2));


    }
    @Test
    public void twoSimilarContactsShouldreturnHIGH(){
        Contact c1 = new Contact();
        c1.setContactId(1000);
        c1.setAddress("449-6990 Tellus. Rd.");
        c1.setFirstName("C");
        c1.setLastName("F");
        c1.setZipCode("");
        c1.setEmailAddress("mollis.lectus.pede@outlook.net");

        Contact c2 = new Contact();
        c2.setContactId(1001);
        c2.setAddress("449-6990 Tellus. Rd.");
        c2.setFirstName("C");
        c2.setLastName("French");
        c2.setZipCode("39746");
        c2.setEmailAddress("mollis.lectus.pede@outlook.net");

        assertEquals("HIGH", c1.isSimilar(c2));

    }
}
