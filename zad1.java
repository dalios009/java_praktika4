public class Main {
    public static void main(String[] args) {
        String input1 = "abracadabra";
        String input2 = "paparazzi";
        
        String result1 = nonRepeatable(input1);
        String result2 = nonRepeatable(input2);
        
        System.out.println(result1); // Вывод: " abrcd"
        System.out.println(result2); // Вывод: " parzi"
    }

    public static String nonRepeatable(String input) {
        if (input.isEmpty()) {
            return "";
        }

        char firstChar = input.charAt(0);
        String restOfTheString = input.substring(1);

        // Удаляем все вхождения первого символа в остатке строки
        restOfTheString = restOfTheString.replace(String.valueOf(firstChar), "");

        // Рекурсивно вызываем функцию для остатка строки и объединяем с первым символом
        return firstChar + nonRepeatable(restOfTheString);
    }
}
