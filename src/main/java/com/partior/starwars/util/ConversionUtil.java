package com.partior.starwars.util;

public class ConversionUtil {

    public static int stringToInt(String input) {
        try {
            return Integer.parseInt(input.replaceAll(",", ""));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

}
