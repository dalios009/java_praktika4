import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int n1 = 1;
        int n2 = 2;
        int n3 = 3;
        
        List<String> result1 = generateBrackets(n1);
        List<String> result2 = generateBrackets(n2);
        List<String> result3 = generateBrackets(n3);
        
        System.out.println(result1); // Вывод: ["()"]
        System.out.println(result2); // Вывод: ["(())", "()()"]
        System.out.println(result3); // Вывод: ["((()))", "(()())", "(())()", "()(())", "()()()"]
    }

    public static List<String> generateBrackets(int n) {
        List<String> combinations = new ArrayList<>();
        generateBracketsRecursive(combinations, "", 0, 0, n);
        return combinations;
    }

    private static void generateBracketsRecursive(List<String> combinations, String current, int openCount, int closeCount, int n) {
        if (current.length() == 2 * n) {
            combinations.add(current);
            return;
        }

        if (openCount < n) {
            generateBracketsRecursive(combinations, current + "(", openCount + 1, closeCount, n);
        }
        if (closeCount < openCount) {
            generateBracketsRecursive(combinations, current + ")", openCount, closeCount + 1, n);
        }
    }
}
