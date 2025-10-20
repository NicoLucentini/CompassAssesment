
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.lucentininicolas.ComparerFilter;
import org.lucentininicolas.Contact;
import org.lucentininicolas.ContactCompareResult;
import org.lucentininicolas.ContactComparer;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactComparerTest {
    private Contact c1;
    private Contact c2;
    private Contact c3;

    @BeforeEach
    public void setUp(){
        c1 = new Contact();
        c1.setContactId(1000);
        c1.setAddress("449-6990 Tellus. Rd.");
        c1.setFirstName("C");
        c1.setLastName("F");
        c1.setZipCode("");
        c1.setEmailAddress("mollis.lectus.pede@outlook.net");

        c2 = new Contact();
        c2.setContactId(1001);
        c2.setAddress("449-6990 Tellus. Rd.");
        c2.setFirstName("C");
        c2.setLastName("French");
        c2.setZipCode("39746");
        c2.setEmailAddress("mollis.lectus.pede@outlook.net");

        c3 = new Contact();
        c3.setContactId(1002);
        c3.setAddress("");
        c3.setFirstName("Ciara");
        c3.setLastName("F");
        c3.setZipCode("39746");
        c3.setEmailAddress("non.lacinia.at@zoho.ca");
    }
    @Test
    public void shouldReturnAResponse(){
        List<ContactCompareResult> results = ContactComparer.compareContacts(List.of(c1,c2,c3));

        assertEquals(6, results.size());
    }
    @Test
    public void shouldReturnAResponseOnlyWithHigh(){
        List<ContactCompareResult> results = ContactComparer.compareContacts(List.of(c1,c2,c3), ComparerFilter.HIGH);

        assertEquals(2, results.size());
    }
}
