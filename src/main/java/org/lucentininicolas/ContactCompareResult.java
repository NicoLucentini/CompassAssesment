package org.lucentininicolas;

public class ContactCompareResult {
    private final int contactId;
    private final int contactIdMatch;
    private final String accuracy;


    public ContactCompareResult(int contactId, int contactIdMatch, String accuracy) {
        this.contactId = contactId;
        this.contactIdMatch = contactIdMatch;
        this.accuracy = accuracy;
    }


    public String getAccuracy() {
        return accuracy;
    }

    @Override
    public String toString() {
        return "ContactCompareResult{" +
                "contactId=" + contactId +
                ", contactIdMatch=" + contactIdMatch +
                ", accuracy='" + accuracy +
                '}';
    }
}
