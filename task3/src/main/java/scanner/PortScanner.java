package scanner;

import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class PortScanner {
    private static final int COUNT_PORTS = 65536;

    public static void main(String[] args) throws IOException {
        String hostIp = "127.0.0.1";
        if (hostIp.isEmpty()) {
            System.out.println("No host ip");
            return;
        }

        System.out.println("Ip: " + hostIp);
        for (int port = 0; port < COUNT_PORTS; port++){
            if (IsPortConnected(hostIp, port)) {
                PrintInfo(port);
            }
        }
    }

    private static String GetHostIp() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return "";
        }
    }

    private static void PrintInfo(int port) {
        if (port < 1024)
            System.out.println("\tSystem port " + port + " is used.");
        else if (port <= 49151)
            System.out.println("\tUser port " + port + " is used.");
        else
            System.out.println("\tPrivate port " + port + " is used.");
    }

    private static boolean IsPortConnected(String ip, int port) throws IOException {
        try {
            Socket socket = new Socket(ip, port);
            socket.close();
            return true;
        } catch (ConnectException e) {
            return false;
        }
    }
}
