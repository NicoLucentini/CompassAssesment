package org.lucentininicolas;

import com.opencsv.bean.CsvBindByName;

public class Contact {
    @CsvBindByName
    public Integer contactId;
    @CsvBindByName
    public String firstName;
    @CsvBindByName
    public String lastName;
    @CsvBindByName
    public String emailAddress;
    @CsvBindByName
    public String zipCode;
    @CsvBindByName
    public String address;

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public double compare(Contact other){
        //The highest the value the better
        //name => 10 points
        //lastName => 10points
        //email =>100 points
        //zipcode =>1 points
        //address => 100 points
        //max 230
        double nameValue = JaroWinklerComparer.compare(firstName, other.firstName) * 10;
        double lastNameValue = JaroWinklerComparer.compare(lastName, other.lastName) * 10;
        double emailValue = JaroWinklerComparer.compare(emailAddress, other.emailAddress) * 100;
        double zipcodeValue = JaroWinklerComparer.compare(zipCode, other.zipCode) ;
        double addressValue = JaroWinklerComparer.compare(address, other.address) * 100;


        if(emailValue == 100 || addressValue == 100){
            return 221;
        }
        return nameValue + lastNameValue + emailValue + zipcodeValue + addressValue;
    }
    public String isSimilar(Contact other){
        double compare = compare(other);
        double normalized = compare / 221;
        System.out.println("Compare results " + compare);
        if(normalized>0.8){
            return "HIGH";
        }
        else if(normalized>0.5 ){
            return "MEDIUM";
        }
        return "LOW";
    }

}
