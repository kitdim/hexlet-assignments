package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

// BEGIN
public class App {
    public static long getCountOfFreeEmails(List<String> emails) {
        List<String> freeDoments = Arrays.asList("gmail.com", "yandex.ru", "hotmail.com");
        long count = emails.stream()
                .map(free -> free.split("@")[1])
                .filter(free -> freeDoments.contains(free))
                .count();
        return count;
    }
}
// END
