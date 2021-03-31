package org.acme.getting.started;

import org.acme.getting.back.Person;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.Set;

@RegisterRestClient(configKey = "users-api")
public interface PersonService {

    @GET
    @Path("/users/{name}")
    Set<Person> getByFirstName(@PathParam String name);

    @GET
    @Path("/users")
    Set<Person> getAllPerson();
}
