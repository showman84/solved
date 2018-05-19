package com.company.Strings;

import java.util.regex.Pattern;

public class ValidIPs {

    public String validIPAddress(String ip) {

        String result = "Neither";
        if (checkIpv4(ip)) {
            result = "IPv4";
        }
        if (checkIpv6(ip)) {
            result = "IPv6";
        }
        return result;
    }

    public boolean checkIpv4(String ip) {

        String[] array = ip.split(Pattern.quote("."));

        if (array.length != 4) {
            return false;
        }

        for (String arrayItem: array) {

            if (arrayItem.startsWith("0")) {
                return false;
            }

            int ipPart = -1;
            try {
                ipPart = Integer.parseUnsignedInt(arrayItem);
            }
            catch (NumberFormatException ex) {
                return false;
            }
            if (ipPart < 0 || ipPart > 255) {
                return false;
            }
        }
        return true;
    }

    public boolean checkIpv6(String ip) {

        String array[] = ip.split(":", -1);

        if (array.length != 8) {
            return false;
        }
        Pattern r = Pattern.compile("\\\\A(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}\\\\z");
        for (String arrayItem: array) {

            if (arrayItem.length() == 0 || arrayItem.length() > 4) {
                return false;
            }

            if (!r.matcher(arrayItem).find()) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

        String ip = "20EE:FGb8:85a3:0:0:8A2E:0370:7334";

        System.out.println(new ValidIPs().validIPAddress(ip));
    }
}
