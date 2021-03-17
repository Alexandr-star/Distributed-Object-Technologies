import java.io.Serializable;

public class Telephone implements Serializable {
    private String phoneNumber;

    public Telephone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Telephone{" +
                "phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
