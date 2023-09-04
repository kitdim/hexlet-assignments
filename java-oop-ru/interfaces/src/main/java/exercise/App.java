package exercise;

import java.util.*;

// BEGIN
class App {
    public static List<String> buildApartmentsList(List<Home> apartments, int count) {
        if (apartments.isEmpty()) {
            return new ArrayList<>();
        }
        Collections.sort(apartments);
        List<String> result = new ArrayList<>();
        for (var i = 0; i < count; i++) {
            result.add(apartments.get(i).toString());
        }
        return result;
    }
}
// END
