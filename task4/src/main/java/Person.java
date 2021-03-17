import java.io.Serializable;

public class Person implements Serializable {
    private  String  firstName;
    private  String  lastName;
    private Address address;
    private Telephone[] telephone;

    public Person(String firstName, String lastName, Address address, Telephone[] telephone) {
        this.firstName = firstName;
        this.lastName  = lastName;
        this.address = address;
        this.telephone = telephone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address adress) {
        this.address = adress;
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

    public Telephone[] getTelephone() {
        return telephone;
    }

    public void setTelephone(Telephone[] telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                ", telephone=" + telephone +
                '}';
    }
}
