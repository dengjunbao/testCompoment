package com.component.test.ExcelUtils.utils;

import javax.servlet.http.HttpServletRequest;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class IPUtil {
    private static String DEFAULT = "";

    public IPUtil() {
    }

    public static String getIpAdd() {
        return getIpAdd(ComUtils.getRequest());
    }

    public static String getIpAdd(HttpServletRequest request) {
        String ipAddress = request.getHeader("x-forwarded-for");
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }

        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }

        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")) {
                InetAddress inet = null;

                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException var4) {
                    return DEFAULT;
                }

                ipAddress = inet.getHostAddress();
            }
        }

        if (ipAddress.split(",").length > 1) {
            ipAddress = ipAddress.split(",")[1].trim();
        }

        return ipAddress;
    }

    public static String getServerName() {
        return ComUtils.getRequest().getServerName();
    }

    public static String getServerIp() {
        try {
            Enumeration allNetInterfaces = NetworkInterface.getNetworkInterfaces();

            while(allNetInterfaces.hasMoreElements()) {
                NetworkInterface netInterface = (NetworkInterface)allNetInterfaces.nextElement();
                Enumeration addresses = netInterface.getInetAddresses();

                while(addresses.hasMoreElements()) {
                    InetAddress ip = (InetAddress)addresses.nextElement();
                    if (ip != null && ip instanceof Inet4Address && !ip.isLoopbackAddress() && ip.getHostAddress().indexOf(":") == -1) {
                        return ip.getHostAddress();
                    }
                }
            }
        } catch (Exception var4) {
            var4.printStackTrace();
        }

        return null;
    }
}
