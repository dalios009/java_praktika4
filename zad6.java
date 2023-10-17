import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println(convertToNum("eight")); // Вывод: 8
        System.out.println(convertToNum("five hundred sixty seven")); // Вывод: 567
        System.out.println(convertToNum("thirty one")); // Вывод: 31
    }

    public static int convertToNum(String input) {
        String[] words = input.split(" ");
        Map<String, Integer> wordToNumber = createWordToNumberMap();

        int result = 0;
        int currentNumber = 0;

        for (String word : words) {
            if (wordToNumber.containsKey(word)) {
                currentNumber = wordToNumber.get(word);
                result += currentNumber;
            } else if (word.equals("hundred")) {
                result *= 100;
            }
        }

        return result;
    }

    private static Map<String, Integer> createWordToNumberMap() {
        Map<String, Integer> wordToNumber = new HashMap<>();
        wordToNumber.put("one", 1);
        wordToNumber.put("two", 2);
        wordToNumber.put("three", 3);
        wordToNumber.put("four", 4);
        wordToNumber.put("five", 5);
        wordToNumber.put("six", 6);
        wordToNumber.put("seven", 7);
        wordToNumber.put("eight", 8);
        wordToNumber.put("nine", 9);
        wordToNumber.put("ten", 10);
        wordToNumber.put("eleven", 11);
        wordToNumber.put("twelve", 12);
        wordToNumber.put("thirteen", 13);
        wordToNumber.put("fourteen", 14);
        wordToNumber.put("fifteen", 15);
        wordToNumber.put("sixteen", 16);
        wordToNumber.put("seventeen", 17);
        wordToNumber.put("eighteen", 18);
        wordToNumber.put("nineteen", 19);
        wordToNumber.put("twenty", 20);
        wordToNumber.put("thirty", 30);
        wordToNumber.put("forty", 40);
        wordToNumber.put("fifty", 50);
        wordToNumber.put("sixty", 60);
        wordToNumber.put("seventy", 70);
        wordToNumber.put("eighty", 80);
        wordToNumber.put("ninety", 90);

        return wordToNumber;
    }
}
