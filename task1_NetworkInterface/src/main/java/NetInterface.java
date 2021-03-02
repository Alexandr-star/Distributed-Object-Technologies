import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;

public class NetInterface {

    public static void main(String[] args) throws SocketException {
        printLine();
        System.out.println("Information about present Network Interfaces...");
        printLine();

        Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
        for (NetworkInterface networkInterface : Collections.list(nets))
            displayInterfaceInformation(networkInterface);
    }

    static void displayInterfaceInformation(NetworkInterface networkInterface) {
        try {
            if (networkInterface.isUp()) {
                System.out.println("Interface Name: " + networkInterface.getName());

                System.out.println("Interface display name: " + networkInterface.getDisplayName());

                System.out.println("Index: " + networkInterface.getIndex());

                System.out.println("MAC Address: " + getStringMacAddress(networkInterface.getHardwareAddress()));

                // Интерфейсные адреса сетевого интерфейса
                System.out.println("Interface addresses: ");

                for (InterfaceAddress address : networkInterface.getInterfaceAddresses())
                    System.out.println("\tIP Address:" + address.getAddress().toString());

            } else {
                System.out.println("Interface " + networkInterface + " don't work.");
            }
        } catch (SocketException e) {
            System.out.println("Warning: " + e.toString());
        }

        printLine();
    }

    private static String getStringMacAddress(byte[] hardwareAddress) {
        if (hardwareAddress == null) return "Address doesn't exist or is not accessible.";

        StringBuilder macAddress = new StringBuilder();
        for (int indexByte = 0; indexByte < hardwareAddress.length; indexByte++)
            macAddress.append(String.format("%02X%s", hardwareAddress[indexByte], indexByte == hardwareAddress.length - 1 ? "" : ":"));

        return macAddress.toString();
    }

    private static void printLine() {
        System.out.println("-----------------------------------------------------");
    }
}