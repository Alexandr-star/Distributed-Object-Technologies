package org.askvor.meat.meetkafka.resteasyjackson;

import io.smallrye.reactive.messaging.kafka.Record;
import org.askvor.meat.meetkafka.resteasyjackson.models.Address;
import org.askvor.meat.meetkafka.resteasyjackson.models.Person;
import org.askvor.meat.meetkafka.resteasyjackson.models.Salary;
import org.askvor.meat.meetkafka.resteasyjackson.models.Telephone;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.math.BigDecimal;

@ApplicationScoped
public class PersonProducer {

    @Inject
    @Channel("persons-out")
    Emitter<Record<Integer, String>> emitter;

    public void sendPersonToKafka(Person person) {
        emitter.send(Record.of(
                person.getId(),
                person.getFirstName()
        ));
    }
}