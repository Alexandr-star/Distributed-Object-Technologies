import java.io.IOException;
import java.net.ConnectException;

public class AccessingServer {
    private static final String IP = "127.0.0.1";
    private static final int PORT = 6000;

    public static void main(String[] args) throws IOException {
        try {
            EchoClient client = new EchoClient();
            client.startConnection(IP, PORT);
            String response = client.sendMessage("This is message");
            System.out.println(response);
            client.stopConnection();
        } catch (ConnectException e) {
            System.out.println(e.getMessage());
        }

    }
}