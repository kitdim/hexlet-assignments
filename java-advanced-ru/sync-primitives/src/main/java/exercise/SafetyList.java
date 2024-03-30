package exercise;

import java.util.Arrays;

class SafetyList {
    // BEGIN
    private int size;
    private int length;
    private int[] elemData;
    private int index;

    public SafetyList() {
        size = 0;
        index = 0;
        length = 15;
        elemData = new int[length];
    }

    public synchronized void add(int elem) {
        if (index + 5 >= elemData.length) {
            length = length * 2;
            elemData = Arrays.copyOf(elemData, length);
        }
        elemData[index] = elem;
        index = index + 1;
        size = size + 1;
    }

    public int get(int elemIndex) {
        if (elemIndex > index) {
            throw new IllegalArgumentException(elemIndex + " out of range.");
        }
        int result = elemData[elemIndex];

        fastRemove(elemIndex);
        return result;
    }
    private void fastRemove(int index) {
        this.index = this.index - 1;
        size = size - 1;
        int[] newArr = new int[elemData.length - 1];
        int newIndex = 0;

        for (int i = 0; i < elemData.length; i++) {
            if (i != index) {
                newArr[newIndex] = elemData[i];
                newIndex++;
            }
        }
        System.arraycopy(newArr, 0, elemData, 0, newArr.length);
    }

    public int getSize() {
        return size;
    }
    // END
}
