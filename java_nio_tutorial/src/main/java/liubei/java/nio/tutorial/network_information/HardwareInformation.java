package liubei.java.nio.tutorial.network_information;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class HardwareInformation {

    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> networkInterfaceEnumeration = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaceEnumeration.hasMoreElements()){
                NetworkInterface networkInterface = networkInterfaceEnumeration.nextElement();
                System.out.println("getName(): " + networkInterface.getName());
                System.out.println("getDisplayName(): " + networkInterface.getDisplayName());
                byte[] bytes = networkInterface.getHardwareAddress();
                if(bytes != null){
                    System.out.println("hardwareAddress: " + HardwareInformation.handlerHardwareAddress(bytes));
                } else{
                    System.out.println("hardwareAddress 为null");
                }
                System.out.println();
                System.out.println();
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }

    }

    public static String handlerHardwareAddress(byte[] bytes){
        if(bytes == null || bytes.length < 1){
            throw new IllegalArgumentException("参数异常");
        }
        String ret = "";
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            ret += hex.toUpperCase();
        }
        return ret;
    }

}
