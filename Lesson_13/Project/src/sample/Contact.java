package sample;

public class Contact {
    private String FirstName;
    private String LastName;
    private String PhoneNumber;
    private String Notes;

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getNotes() {
        return Notes;
    }
}
