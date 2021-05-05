package org.askvor.meat.meetkafka.resteasyjackson.models;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class Person implements Serializable {
    private int id;
    private String  firstName;
    private String  lastName;
    private String email;
    private Address address;
    private Telephone telephone;
    private Salary salary;

    public Person(int id, String email, String firstName, String lastName, Address address, Telephone telephone) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName  = lastName;
        this.address = address;
        this.telephone = telephone;
    }

    public Person() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Telephone getTelephone() {
        return telephone;
    }

    public void setTelephone(Telephone telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", telephone=" + telephone +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && firstName.equals(person.firstName) && lastName.equals(person.lastName) && email.equals(person.email) && address.equals(person.address) && telephone.equals(person.telephone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, address, telephone);
    }
}
