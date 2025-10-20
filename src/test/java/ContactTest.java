import org.junit.jupiter.api.Test;
import org.lucentininicolas.Contact;

import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {
    @Test
    public void twoEqualsContactShouldReturn_230(){
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

        assertEquals(230.0, c1.compare(c2));

    }
    @Test
    public void twoDifferentsContactShouldNotBeSimilar(){
        Contact c1 = new Contact();
        c1.setAddress("address");
        c1.setFirstName("name");
        c1.setLastName("last");
        c1.setZipCode("123");
        c1.setEmailAddress("email@test.com");

        Contact c2 = new Contact();
        c2.setAddress("mansilla");
        c2.setFirstName("julieta");
        c2.setLastName("lucentini");
        c2.setZipCode("123");
        c2.setEmailAddress("juliasdasdasdasdas@test.com");

        assertFalse(c1.isSimilar(c2));

    }
}
