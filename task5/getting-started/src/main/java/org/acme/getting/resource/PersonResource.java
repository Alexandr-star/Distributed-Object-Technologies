package org.acme.getting.resource;

import org.acme.getting.back.Address;
import org.acme.getting.back.Person;
import org.acme.getting.back.Telephone;
import org.acme.getting.started.PersonService;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.*;

@Path("/persons")
public class PersonResource {

    @Inject
    @RestClient
    PersonService personService;

    private Set<Person> persons = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    public PersonResource() {
        persons.add(new Person(
                1,
                "qwer@qwe.com",
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
                2,
                "ewq@qw.ru",
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
    public Set<Person> getAllPersons() {
        return personService.getAllPerson();
    }

    @GET
    @Path("/{id}")
    public Set<Person> getPersonById(@PathParam int id) {
        persons.stream().filter(person -> person.getId() == id);
        return persons;
    }


    @GET
    @Path("/name/{first_name}")
    public Set<Person> getPersonByFirstName(@PathParam String first_name) {
        return personService.getByFirstName(first_name);
    }

    @POST
    public Set<Person> add(Person fruit) {
        persons.add(fruit);
        return persons;
    }

    @DELETE
    public Set<Person> delete(Person person) {
        persons.removeIf(existingPerson -> existingPerson.getFirstName().contentEquals(person.getFirstName()));
        return persons;
    }
}
