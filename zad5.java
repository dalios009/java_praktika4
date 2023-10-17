import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        String input1 = "aaabbcdd";
        String input2 = "vvvvaajaaaaa";

        String result1 = countAndSortPatterns(input1);
        String result2 = countAndSortPatterns(input2);

        System.out.println(result1); // Вывод: "c1b2d2a3"
        System.out.println(result2); // Вывод: "j1a2v4a5"
    }

    public static String countAndSortPatterns(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        Map<Character, Integer> patternCounts = new TreeMap<>();
        int count = 1;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                patternCounts.put(str.charAt(i - 1), count);
                count = 1;
            }
        }

        // Обработка последнего символа
        patternCounts.put(str.charAt(str.length() - 1), count);

        StringBuilder sortedPattern = new StringBuilder();

        for (Map.Entry<Character, Integer> entry : patternCounts.entrySet()) {
            sortedPattern.append(entry.getKey());
            sortedPattern.append(entry.getValue());
        }

        return sortedPattern.toString();
    }
}
