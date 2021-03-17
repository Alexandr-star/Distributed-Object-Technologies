import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.databind.*;

import java.io.IOException;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.*;

class Serializable_Externalizable_Person_Test {
    private static final String STREET_ADDRESS = "Московское ш., 101, кв.101";
    private static final String CITY = "Ленинград";
    private static final int POSTAL_CODE = 101101;

    private static final String FIRST_PHONE_NUMBERS = "812 123-1234";
    private static final String SECOND_PHONE_NUMBERS = "916 123-4567";

    private static final String FIRST_NAME = "Иван";
    private static final String SECOND_NAME = "Иванов";

    @Test
    void testSerialization() throws IOException
    {
        try {
            Address address = new Address(STREET_ADDRESS, CITY, POSTAL_CODE);

            Telephone[] telephones = {
                    new Telephone(FIRST_PHONE_NUMBERS),
                    new Telephone(SECOND_PHONE_NUMBERS)
            };

            Person person = new Person(
                    FIRST_NAME,
                    SECOND_NAME,
                    address,
                    telephones
            );

            StringWriter writer = new StringWriter();

            ObjectMapper mapper = new ObjectMapper();

            mapper.writeValue(writer, person);

            String result = writer.toString();
            String actual = getActualDataForSerialization();

            assertEquals(result, actual);
        } catch (Exception e) {
            fail("Exception thrown during test: " + e.toString());
        }
    }

    private String getActualDataForSerialization() {
        return "{" +
                    "\"firstName\":\"Иван\"," +
                    "\"lastName\":\"Иванов\"," +
                    "\"address\":{" +
                        "\"streetAddress\":\"Московское ш., 101, кв.101\"," +
                        "\"city\":\"Ленинград\"," +
                        "\"postalCode\":101101" +
                    "}," +
                    "\"telephone\":[" +
                        "{\"phoneNumber\":\"812 123-1234\"}," +
                        "{\"phoneNumber\":\"916 123-4567\"}" +
                    "]" +
                "}";
    }
}
