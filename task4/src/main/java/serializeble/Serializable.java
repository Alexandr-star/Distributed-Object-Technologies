package serializeble;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.io.StringWriter;

public class Serializable {
    public String JsonSerialize(Object object) throws IOException {
        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();

        mapper.writeValue(writer, object);

        return writer.toString();
    }

    public String YamlSerialize(Object object) throws  IOException {
        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

        mapper.writeValue(writer, object);

        return writer.toString();
    }

    public String XmlSerialize(Object object) throws  IOException {
        StringWriter writer = new StringWriter();
        XmlMapper mapper = new XmlMapper();

        mapper.writeValue(writer, object);

        return writer.toString();
    }
}
