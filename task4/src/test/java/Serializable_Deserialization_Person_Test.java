import deserialization.Deserialization;
import org.junit.jupiter.api.Test;
import serializeble.Serializable;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Serializable_Deserialization_Person_Test {
    private static final String STREET_ADDRESS = "Московское ш., 101, кв.101";
    private static final String CITY = "Ленинград";
    private static final int POSTAL_CODE = 150001;

    private static final String FIRST_PHONE_NUMBERS = "812 123-1234";
    private static final String SECOND_PHONE_NUMBERS = "916 123-4567";

    private static final String FIRST_NAME = "Иван";
    private static final String LAST_NAME = "Иванов";

    private Serializable serializable = new Serializable();
    private Deserialization deserialization = new Deserialization();


    private Object GetPerson() {
        Address address = new Address(STREET_ADDRESS, CITY, POSTAL_CODE);

        Telephone[] telephones = {
                new Telephone(FIRST_PHONE_NUMBERS),
                new Telephone(SECOND_PHONE_NUMBERS)
        };

        return new Person(
                FIRST_NAME,
                LAST_NAME,
                address,
                telephones
        );
    }

    @Test
    void SerializationFromObjectToJSON() throws IOException
    {
        //data
        Object person = GetPerson();
        String exceptedDataForSerialization = GetJsonData();

        //Serialization
        String personJson = serializable.JsonSerialize(person);

        //assert
        assertEquals(exceptedDataForSerialization, personJson);
    }

    @Test
    void SerializationFromObjectToYAML() throws IOException {
        //data
        Object person = GetPerson();
        String exceptedDataForSerialization = GetYAMLData();

        //Serialization
        String personYaml = serializable.YamlSerialize(person);

        //assert
        assertEquals(exceptedDataForSerialization, personYaml);
    }

    @Test
    void SerializationFromObjectToXML() throws IOException {
        //data
        Object person = GetPerson();
        String exceptedDataForSerialization = GetXmlData();

        //Serialization
        String personXml = serializable.XmlSerialize(person);

        //assert
        assertEquals(exceptedDataForSerialization, personXml);
    }

    @Test
    void DeserializationFromJSONToObject() throws IOException {
        //data
        Object person = GetPerson();
        String personJson = serializable.JsonSerialize(person);

        //Deserialization
        Object personFromJson = deserialization.JsonDeserialize(personJson, Person.class);

        //assert
        assertEquals(person, personFromJson);
    }

    @Test
    void DeserializationFromYAMLToObject() throws IOException {
        //data
        Object person = GetPerson();
        String personYaml = serializable.YamlSerialize(person);

        //Deserialization
        Object personFromYaml = deserialization.YamlDeserialize(personYaml, Person.class);

        //assert
        assertEquals(person, personFromYaml);
    }

    @Test
    void DeserializationFromXMLToObject() throws IOException {
        //data
        Object person = GetPerson();
        String personXml = serializable.XmlSerialize(person);

        //Deserialization
        Object personFromXml = deserialization.XmlDeserialize(personXml, Person.class);

        //assert
        assertEquals(person, personFromXml);
    }

    private String GetJsonData() {
        return "{" +
                    "\"firstName\":\"" + FIRST_NAME+ "\"," +
                    "\"lastName\":\"" + LAST_NAME+ "\"," +
                    "\"address\":{" +
                        "\"streetAddress\":\"" + STREET_ADDRESS+ "\"," +
                        "\"city\":\"" + CITY + "\"," +
                        "\"postalCode\":" + POSTAL_CODE +
                    "}," +
                    "\"telephone\":[" +
                        "{\"phoneNumber\":\"" + FIRST_PHONE_NUMBERS + "\"}," +
                        "{\"phoneNumber\":\"" + SECOND_PHONE_NUMBERS + "\"}" +
                    "]" +
                "}";
    }

    private String GetYAMLData() {
        return "---\n" +
                "firstName: \"" + FIRST_NAME + "\"\n" +
                "lastName: \""+ LAST_NAME +"\"\n" +
                "address:\n" +
                "  streetAddress: \"" + STREET_ADDRESS + "\"\n" +
                "  city: \""+ CITY + "\"\n" +
                "  postalCode: " + POSTAL_CODE + "\n" +
                "telephone:\n" +
                "- phoneNumber: \"" + FIRST_PHONE_NUMBERS + "\"\n" +
                "- phoneNumber: \"" + SECOND_PHONE_NUMBERS + "\"\n";
    }

    private String GetXmlData() {
        return "<Person>" +
                    "<firstName>"+ FIRST_NAME+"</firstName>" +
                    "<lastName>" + LAST_NAME + "</lastName>" +
                    "<address>" +
                        "<streetAddress>" + STREET_ADDRESS + "</streetAddress>" +
                        "<city>" + CITY + "</city>" +
                        "<postalCode>" + POSTAL_CODE + "</postalCode>" +
                    "</address>" +
                    "<telephone>" +
                        "<telephone>" +
                            "<phoneNumber>" + FIRST_PHONE_NUMBERS + "</phoneNumber>" +
                        "</telephone>" +
                        "<telephone>" +
                            "<phoneNumber>" + SECOND_PHONE_NUMBERS + "</phoneNumber>" +
                        "</telephone>" +
                    "</telephone>" +
                "</Person>";
    }
}
