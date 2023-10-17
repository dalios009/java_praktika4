public class Main {
    public static void main(String[] args) {
        String input1 = "abcdjuwx";
        String input2 = "klmabzyxw";

        String result1 = alphabeticRow(input1);
        String result2 = alphabeticRow(input2);

        System.out.println(result1); // Вывод: "abcd"
        System.out.println(result2); // Вывод: "zyxw"
    }

    public static String alphabeticRow(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }

        String longestRow = "";
        String currentRow = String.valueOf(str.charAt(0));

        for (int i = 1; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            char previousChar = str.charAt(i - 1);

            if (currentChar == previousChar + 1 || currentChar == previousChar - 1) {
                currentRow += currentChar;
            } else {
                if (currentRow.length() > longestRow.length()) {
                    longestRow = currentRow;
                }
                currentRow = String.valueOf(currentChar);
            }
        }

        // Проверяем последний ряд
        if (currentRow.length() > longestRow.length()) {
            longestRow = currentRow;
        }

        return longestRow;
    }
}
