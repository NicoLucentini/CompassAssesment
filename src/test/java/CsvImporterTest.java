import org.junit.jupiter.api.Test;
import org.lucentininicolas.Contact;
import org.lucentininicolas.CsvImporter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CsvImporterTest {
    @Test
    void testReadFile_ValidCSV_ReturnsListOfPersons() throws Exception {
        // Arrange
        String csvContent = """
                name,firstName,lastName,emailAddress,zipCode,address
                1001,C,F,test@example.com,,449-25-TellusRd
                1002,Casa,French,test2@example.com,479,449-26-TellusRd
                1002,Clara,F,test3@example.com,479,
                """;

        Path tempFile = Files.createTempFile("contacts", ".csv");
        Files.writeString(tempFile, csvContent);

        //List<Contact> contacts = CsvImporter.readFile(tempFile.toString(), Contact.class);
        List<Contact> contacts = CsvImporter.readFile(tempFile.toString(), Contact.class);

        assertNotNull(contacts);
        assertEquals(3, contacts.size());
        assertEquals("C", contacts.get(0).getFirstName());
        assertEquals("test2@example.com", contacts.get(1).getEmailAddress());
        assertEquals("479", contacts.get(2).getZipCode());

        Files.deleteIfExists(tempFile);
    }


    @Test
    void testReadFile_EmptyFile_ReturnsEmptyList() throws Exception {
        Path emptyFile = Files.createTempFile("empty", ".csv");

        List<Contact> contacts = CsvImporter.readFile(emptyFile.toString(), Contact.class);

        assertNotNull(contacts);
        assertTrue(contacts.isEmpty());

        Files.deleteIfExists(emptyFile);
    }

    @Test
    void testReadFile_NonExistentFile_ReturnsEmptyList() {
        List<Contact> contacts = CsvImporter.readFile("nonexistent.csv", Contact.class);
        assertNotNull(contacts);
        assertTrue(contacts.isEmpty());
    }

}
