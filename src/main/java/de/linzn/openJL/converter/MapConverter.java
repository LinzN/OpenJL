package de.linzn.openJL.converter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MapConverter {
    /* Convert a HashMap to a string for saving in a mysql file */
    public static String mapToString(Map<String, String> map) {
        StringBuilder codecString = new StringBuilder();

        for (String mapTest : map.keySet()) {
            String item = mapTest + "=" + map.get(mapTest);
            if (Objects.equals(codecString.toString(), "")) {
                codecString = new StringBuilder(item);
            } else {
                codecString.append("#").append(item);
            }
        }
        return codecString.toString();
    }

    /* Convert a String back to a HashMap from a mysql database */
    public static Map<String, String> stringToMap(String codecString) {
        if (codecString != null && !Objects.equals(codecString, "")) {
            Map<String, String> map = new HashMap<>();
            for (String itemStack : codecString.split("#")) {
                String[] item = itemStack.split("=");
                map.put(item[0], item[1]);
            }
            return map;
        }
        return null;
    }
}
