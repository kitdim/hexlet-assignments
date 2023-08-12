package exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

// BEGIN
public class App {
    public static void main(String[] arg) {
        Map<String, Integer> map = getWordCount("");
        String result = toString(map);
        System.out.println(result);
    }

    public static Map<String, Integer> getWordCount(String str) {
        if (str.isEmpty()) {
            return new HashMap<>();
        }
        List<String> list = new ArrayList<>(Arrays.asList(str.split(" ")));
        Map<String, Integer> map = new HashMap<>();
        for (String word : list) {
            Integer count = map.get(word);
            if (count == null) {
                count = 0;
            }

            map.put(word, count + 1);
        }
        return map;
    }

    public static String toString(Map<String, Integer> map) {
        if (map.isEmpty()) {
            return "{}";
        }
        StringBuilder res = new StringBuilder("{\n");
        for (Map.Entry<String, Integer> tempMap : map.entrySet()) {
            res.append("  " + tempMap.getKey() + ":" + " " + tempMap.getValue() + "\n");
        }
        res.append("}");
        return res.toString();
    }
}
//END
