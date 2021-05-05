package org.askvor.meat.meetkafka.resteasyjackson;

import jdk.nashorn.internal.codegen.CompilerConstants;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.askvor.meat.meetkafka.resteasyjackson.models.Person;
import org.askvor.meat.meetkafka.resteasyjackson.models.Salary;
import org.jboss.resteasy.annotations.SseElementType;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Request;
//import javax.ws.rs.core.Response;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PersonResources {

    @Inject
    PersonProducer _personProducer;

    private Set<Person> persons = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

//    @POST
//    public Response sendPerson(Person person){
//        _personProducer.sendPersonToKafka(person);
//        return Response.accepted().build();
//    }

    @GET
    @Path("/convert/{id}")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    @Consumes(MediaType.APPLICATION_JSON)
    public String convertSalary(@PathParam int id){
        persons.forEach(
                person -> {
                    if (person.getId() == id) {
//                        String request = getConvertValue(person.getSalary().getCurrency());
//                        String salary = ge
                    }
                }
        );
        return "";
    }

    private String getConvertValue() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://localhost:8000/currency-exchange/from/RUB/to/EUR")
                .build();

        Call call = client.newCall(request);
        Response response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String responseText = null;
        try {
            responseText = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return responseText;
    }

}
