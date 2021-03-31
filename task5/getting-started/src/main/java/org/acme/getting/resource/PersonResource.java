package org.acme.getting.resource;

import org.acme.getting.back.Address;
import org.acme.getting.back.Person;
import org.acme.getting.back.Telephone;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

@Path("/person")
public class PersonResource {

    private Set<Person> persons = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    public PersonResource() {
        persons.add(new Person(
                "Alexandr",
                "Skvorsov",
                new Address(
                        "Street",
                        "City",
                        150012),
                new Telephone[] {
                        new Telephone("123-2213-21"),
                        new Telephone("23-123-23")
                }));
        persons.add(new Person(
                "Alexandr",
                "Notskvorsov",
                new Address(
                        "Street2",
                        "City2",
                        150112),
                new Telephone[] { new Telephone("143-2213-21") }
                ));
    }

    @GET
    public Set<Person> list() {
        return persons;
    }

    @POST
    public Set<Person> add(Person fruit) {
        persons.add(fruit);
        return persons;
    }

    @DELETE
    public Set<Person> delete(Person fruit) {
        persons.removeIf(existingPerson -> existingPerson.getFirstName().contentEquals(fruit.getFirstName()));
        return persons;
    }
}
