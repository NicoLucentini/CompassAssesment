package org.lucentininicolas;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws URISyntaxException {

        URL resource = Main.class.getResource("/data.csv");
        Path path = Paths.get(resource.toURI());

        //Contact parsing
        List<Contact> contacts = CsvImporter.readFile(path.toString(), Contact.class);

        List<ContactCompareResult> results = ContactComparer.compareContacts(contacts, ComparerFilter.HIGH);

        for(int i = 0;i< results.size();i++){
            System.out.println(results.get(i).toString());
        }

    }
}