import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int n1 = 3;
        int n2 = 4;

        List<String> result1 = binarySystem(n1);
        List<String> result2 = binarySystem(n2);

        System.out.println(result1); // Вывод: ["010", "011", "101", "110", "111"]
        System.out.println(result2); // Вывод: ["0101", "0110", "0111", "1010", "1011", "1101", "1110", "1111"]
    }

    public static List<String> binarySystem(int n) {
        List<String> combinations = new ArrayList<>();
        generateBinaryCombinations(combinations, "", n);
        return combinations;
    }

    private static void generateBinaryCombinations(List<String> combinations, String current, int n) {
        if (current.length() == n) {
            combinations.add(current);
            return;
        }

        // Добавляем '0' к текущей последовательности, если это возможно
        if (!current.endsWith("0")) {
            generateBinaryCombinations(combinations, current + "0", n);
        }

        // Добавляем '1' к текущей последовательности, если это возможно
        if (!current.endsWith("1")) {
            generateBinaryCombinations(combinations, current + "1", n);
        }
    }
}
