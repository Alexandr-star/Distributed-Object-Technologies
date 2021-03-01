import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;

public class Main {

    public static void main(String[] args) throws SocketException, UnknownHostException {
        InetAddress iAddress = null;
        try
        {
            iAddress = InetAddress.getLocalHost();
        }
        catch(UnknownHostException ex)
        {
            System.out.println(ex.toString());
        }

        printInetAddresssInfo(iAddress);

        // getNetworkInterfaces () возвращает список всех интерфейсов
        // присутствует в системе.
        ArrayList<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());

        System.out.println("\nInformation about present Network Interfaces...\n");

        for (NetworkInterface networkInterface : interfaces) {
            // находится ли интерфейс в процессе, запущен или работает или нет.
            if (networkInterface.isUp()) {
                System.out.println("Interface Name: " + networkInterface.getName());

                System.out.println("Interface display name: " + networkInterface.getDisplayName());

                System.out.println("Parent: " + networkInterface.getParent());

                System.out.println("Index: " + networkInterface.getIndex());

                System.out.println("MAC Address: " + getStringMacAddress(networkInterface.getHardwareAddress()));

                // Интерфейсные адреса сетевого интерфейса
                System.out.println("\tInterface addresses: ");

                for (InterfaceAddress address : networkInterface.getInterfaceAddresses()) {

                }

                System.out.println("\tInetAddresses associated with this interface: ");

                Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();

                while (inetAddresses.hasMoreElements()) {

                }
            }
        }
    }

    private static String getStringMacAddress(byte[] hardwareAddress) {
        if (hardwareAddress == null) return "none";

        String macAddress = "";
        for (byte bAddress: hardwareAddress) {
            macAddress += bAddress + ":";
        }

        return macAddress;
    }

    private static void printInetAddresssInfo(InetAddress iaRemoteAddress) {
        System.out.println("Address: " + iaRemoteAddress);

        System.out.println("Host name: " + iaRemoteAddress.getHostName());

        byte[] ip = new byte[4];
        ip = iaRemoteAddress.getAddress();

        System.out.println("IP Address: " +
                (0xff & (int)ip[0]) + "." +
                (0xff & (int)ip[1]) + "." +
                (0xff & (int)ip[2]) + "." +
                (0xff & (int)ip[3]));
    }
}