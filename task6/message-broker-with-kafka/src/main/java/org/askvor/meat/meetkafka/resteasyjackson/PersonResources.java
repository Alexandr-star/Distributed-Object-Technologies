package org.askvor.meat.meetkafka.resteasyjackson;

import org.askvor.meat.meetkafka.resteasyjackson.models.Person;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PersonResources {

    @Inject
    PersonProducer _personProducer;

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public Response addPerson(Person person){
        _personProducer.sendPersonToKafka(person);
        return Response.accepted().build();
    }
}
