package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

// BEGIN
public class App {
    public static int getCountOfFreeEmails(List<String> emails) {
        List<String> freeDoments = List.of("@gmail.com", "@yandex.ru", "@hotmail.com");
        int count = (int) emails.stream()
                .filter(free -> free.contains(freeDoments.get(0)))
                .count();
        count += (int) emails.stream()
                .filter(free -> free.contains(freeDoments.get(1)))
                .count();
        count += (int) emails.stream()
                .filter(free -> free.contains(freeDoments.get(2)))
                .count();
        return count;
    }
}
// END
