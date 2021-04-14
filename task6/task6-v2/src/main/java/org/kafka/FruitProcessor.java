package org.kafka;

import io.smallrye.reactive.messaging.annotations.Broadcast;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.kafka.model.Fruit;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FruitProcessor {

    private static final double CONVERSION_RATE = 0.88;

    @Incoming("fruit-in")
    @Outgoing("fruit-out")
    @Broadcast
    public Fruit process(Fruit fruit) {
        fruit.price = (int) (fruit.price * CONVERSION_RATE);
        return fruit;
    }

}