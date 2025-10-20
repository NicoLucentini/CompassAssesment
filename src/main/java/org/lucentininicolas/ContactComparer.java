package org.lucentininicolas;

import java.util.ArrayList;
import java.util.List;

public class ContactComparer {
    public static List<ContactCompareResult> compareContacts(List<Contact> contacts, ComparerFilter filter){
       List<ContactCompareResult> results = new ArrayList<>();
        for(int i = 0; i< contacts.size();i++){
            for(int j = 0; j< contacts.size();j++){
                if(i==j) continue;

                String accuracy = contacts.get(i).isSimilar(contacts.get(j));
                ContactCompareResult result = new ContactCompareResult(
                        contacts.get(i).getContactId(),
                        contacts.get(j).getContactId(),
                        accuracy);

                if(filter == ComparerFilter.HIGH && accuracy.equals("HIGH")) {
                    results.add(result);
                }
                else if(filter == ComparerFilter.HIGH_MEDIUM && (accuracy.equals("HIGH") || accuracy.equals("MEDIUM"))){
                    results.add(result);
                }
                else if(filter == ComparerFilter.ALL){
                    results.add(result);
                }
            }
        }
        return results;
    }
    public static List<ContactCompareResult> compareContacts(List<Contact> contacts){
        return  compareContacts(contacts, ComparerFilter.ALL);
    }
}
