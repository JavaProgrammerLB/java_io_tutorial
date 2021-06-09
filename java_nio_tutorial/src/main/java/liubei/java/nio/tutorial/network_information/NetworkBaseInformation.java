package liubei.java.nio.tutorial.network_information;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class NetworkBaseInformation {

    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> networkInterfaceEnumeration = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaceEnumeration.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaceEnumeration.nextElement();
                System.out.println("getName获取结果为：" + networkInterface.getName());
                System.out.println("getDisplayName获取结果为：" + networkInterface.getDisplayName());
                System.out.println("getIndex获取结果为：" + networkInterface.getIndex());
                System.out.println("是否已经开启: " + networkInterface.isUp());
                System.out.println("是否回环: " + networkInterface.isLoopback());
                System.out.println("获得MTU的最大传输单元：" + networkInterface.getMTU());
                System.out.println();
                System.out.println();
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

}
