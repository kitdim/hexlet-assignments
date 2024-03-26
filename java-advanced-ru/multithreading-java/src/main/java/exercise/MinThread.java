package exercise;

import java.util.Arrays;

// BEGIN
public class MinThread extends Thread {
    private final int[] entity;
    private int result;

    public MinThread(int[] entity) {
        this.entity = entity;
    }
    public int getResult() {
        return result;
    }

    @Override
    public void run() {
        this.result = Arrays.stream(entity).min().orElse(-1);
    }
}
// END
