package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
class App {
    public static void main(String[] args) {
    }

    public static boolean scrabble(String letters, String word) {
        if (letters.length() < word.length()) {
            return false;
        }
        List<String> letterList = new ArrayList<>(Arrays.asList(letters.toLowerCase().split("")));
        List<String> wordList = new ArrayList<>(Arrays.asList(word.toLowerCase().split("")));
        List<String> resultList = new ArrayList<>();
        int resultSize = wordList.size();
        for (var item : letterList) {
            if (wordList.contains(item)) {
                resultList.add(item);
                wordList.remove(item);
            }
        }
        return resultList.size() == resultSize;
    }
}
//END
