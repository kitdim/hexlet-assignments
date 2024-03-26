package exercise;

import java.util.Arrays;

// BEGIN
public class MaxThread extends Thread {
    private final int[] entity;
    private int result;

    public MaxThread(int[] entity) {
        this.entity = entity;
    }
    public int getResult() {
        return result;
    }

    @Override
    public void run() {
        this.result = Arrays.stream(entity).max().orElse(-1);
    }
}
// END
