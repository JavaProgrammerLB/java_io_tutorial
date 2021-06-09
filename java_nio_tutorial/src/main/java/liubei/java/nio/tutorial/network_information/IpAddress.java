package liubei.java.nio.tutorial.network_information;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class IpAddress {

    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> networkInterfaceEnumeration = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaceEnumeration.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaceEnumeration.nextElement();
                System.out.println("getName(): " + networkInterface.getName());
                System.out.println("getDisplayName(): " + networkInterface.getDisplayName());
                System.out.println("开始获取IP信息");
                Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = inetAddresses.nextElement();
                    System.out.println("完全限定域名：" + inetAddress.getCanonicalHostName());
                    System.out.println("主机名：" + inetAddress.getHostName());
                    System.out.println("IP地址字符串： " + inetAddress.getHostAddress());
                    System.out.println("获取原始IP地址");
                    byte[] bytes = inetAddress.getAddress();
                    System.out.println("bytes = " + HardwareInformation.handlerHardwareAddress(bytes));
                    if (inetAddresses.hasMoreElements()){
                        System.out.println("---- 分隔符 ----");
                    }
                }

                System.out.println();
                System.out.println();
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }

    }

}
