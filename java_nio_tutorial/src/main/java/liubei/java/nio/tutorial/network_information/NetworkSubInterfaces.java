package liubei.java.nio.tutorial.network_information;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class NetworkSubInterfaces {

    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> networkInterfaceEnumeration = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaceEnumeration.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaceEnumeration.nextElement();
                System.out.println("getName(): " + networkInterface.getName());
                System.out.println("getDisplayName()：" + networkInterface.getDisplayName());
                System.out.println("isVirtual(): " + networkInterface.isVirtual());
                System.out.println("getParent() 然后获取hashcode为： " + networkInterface.getParent());

                // 子网络
                Enumeration<NetworkInterface> subNetworkInterface = networkInterface.getSubInterfaces();
                while (subNetworkInterface.hasMoreElements()){
                    NetworkInterface networkInterface1 = subNetworkInterface.nextElement();
                    System.out.println("sub getName(): " + networkInterface1.getName());
                    System.out.println("sub getDisplayName(): " + networkInterface1.getDisplayName());
                    System.out.println("sub isVirtual(): " + networkInterface1.isVirtual());
                    System.out.println("sub getParent() 然后获取hashcode: " + networkInterface1.getParent().hashCode());
                }
                System.out.println();
                System.out.println();
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

}
