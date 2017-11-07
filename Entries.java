import java.io.IOException;

public class Entries extends Main {

    private String phone;
    private String last;
    private String first;

    Entries(String phoneNumber, String lastName, String firstName) throws IOException {
        phone = phoneNumber;
        last = lastName;
        first = firstName;
    }

    public String getPhoneNumber(){
        return phone;
    }

    public String getLastName(){
        return last;
    }

    public String getFirstName(){
        return first;
    }
}
