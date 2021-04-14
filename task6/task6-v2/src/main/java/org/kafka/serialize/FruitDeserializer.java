package org.kafka.serialize;

import io.quarkus.kafka.client.serialization.JsonbDeserializer;
import org.kafka.model.Fruit;

public class FruitDeserializer extends JsonbDeserializer<Fruit> {
    public FruitDeserializer(){
        super(Fruit.class);
    }
}