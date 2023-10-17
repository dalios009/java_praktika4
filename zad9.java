import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng")); // Вывод: " One ring to rule them all"
        System.out.println(numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat")); // Вывод: " With great power comes great responsibility"
    }

    public static String numericOrder(String input) {
        String[] words = input.split(" ");
        
        // Создаем массив, который будет хранить слова и их позиции
        WordPosition[] wordPositions = new WordPosition[words.length];

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int position = extractPositionFromWord(word);

            wordPositions[i] = new WordPosition(word, position);
        }

        // Сортируем массив слов и позиций по позициям
        Arrays.sort(wordPositions, Comparator.comparingInt(WordPosition::getPosition));

        // Строим новую строку, объединяя слова в порядке сортировки
        StringBuilder result = new StringBuilder();
        for (WordPosition wp : wordPositions) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(wp.getWord());
        }

        return result.toString();
    }

    private static int extractPositionFromWord(String word) {
        int position = 0;
        int len = word.length();
        int multiplier = 1;

        for (int i = len - 1; i >= 0; i--) {
            char ch = word.charAt(i);
            if (Character.isDigit(ch)) {
                position += (ch - '0') * multiplier;
                multiplier *= 10;
            } else {
                break; // Нашли не-цифровой символ, завершаем извлечение
            }
        }

        return position;
    }

    // Класс для хранения слов и их позиций
    static class WordPosition {
        private String word;
        private int position;

        public WordPosition(String word, int position) {
            this.word = word;
            this.position = position;
        }

        public String getWord() {
            return word;
        }

        public int getPosition() {
            return position;
        }
    }
}
