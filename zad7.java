public class Main {
    public static void main(String[] args) {
        System.out.println(uniqueSubstring("123412324")); // Вывод: "1234"
        System.out.println(uniqueSubstring("111111"));    // Вывод: "1"
        System.out.println(uniqueSubstring("77897898"));  // Вывод: "789"
    }

    public static String uniqueSubstring(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        String maxSubstring = "";
        int maxLength = 0;

        for (int i = 0; i < input.length(); i++) {
            StringBuilder currentSubstring = new StringBuilder();
            int j = i;

            while (j < input.length() && currentSubstring.indexOf(String.valueOf(input.charAt(j)) ) == -1) {
                currentSubstring.append(input.charAt(j));
                j++;
            }

            if (currentSubstring.length() > maxLength) {
                maxSubstring = currentSubstring.toString();
                maxLength = currentSubstring.length();
            }
        }

        return maxSubstring;
    }
}
