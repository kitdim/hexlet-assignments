package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String, Integer> getMinMax(int[] numbers) {
        MaxThread max = new MaxThread(numbers);
        MinThread min = new MinThread(numbers);
        Map<String, Integer> res = new HashMap<>();
        max.start();
        min.start();

        try {
            max.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            min.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        res.put("min", min.getResult());
        res.put("max", max.getResult());
        return res;
    }
    // END
}
