package deserialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.io.StringReader;

public class Deserialization {
    public Object JsonDeserialize(String personJson, Class objectClass) throws IOException {
        StringReader reader = new StringReader(personJson);
        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(reader, objectClass);
    }
    public Object YamlDeserialize(String personYaml, Class objectClass) throws IOException {
        StringReader reader = new StringReader(personYaml);
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

        return mapper.readValue(reader, objectClass);
    }

    public Object XmlDeserialize(String personXml, Class objectClass) throws IOException {
        StringReader reader = new StringReader(personXml);
        XmlMapper mapper = new XmlMapper();

        return mapper.readValue(reader, objectClass);
    }
}
