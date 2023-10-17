public class Main {
    public static void main(String[] args) {
        System.out.println(switchNums(519, 723)); // Вывод: 953
        System.out.println(switchNums(491, 3912)); // Вывод: 9942
        System.out.println(switchNums(6274, 71259)); // Вывод: 77659
    }

    public static int switchNums(int num1, int num2) {
        String strNum1 = Integer.toString(num1);
        String strNum2 = Integer.toString(num2);

        int[] countNum1 = new int[10];
        for (char c : strNum1.toCharArray()) {
            countNum1[c - '0']++;
        }

        StringBuilder result = new StringBuilder();
        int indexNum1 = 0;

        for (char c : strNum2.toCharArray()) {
            int digit = c - '0';

            while (indexNum1 < strNum1.length()) {
                int currentDigit = strNum1.charAt(indexNum1) - '0';

                if (currentDigit < digit && countNum1[currentDigit] > 0) {
                    result.append(currentDigit);
                    countNum1[currentDigit]--;
                } else {
                    break;
                }

                indexNum1++;
            }

            result.append(digit);
        }

        // Добавляем оставшиеся максимально возможные цифры из первого числа
        for (int i = 9; i >= 0; i--) {
            while (countNum1[i] > 0) {
                result.append(i);
                countNum1[i]--;
            }
        }

        return Integer.parseInt(result.toString());
    }
}

