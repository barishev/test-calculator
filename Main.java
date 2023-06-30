import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите арифметическую операцию (например, 1 + 2):");
        String input = scanner.nextLine();
        try {
            System.out.println("Результат: " + calc(input));
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static String calc(String input) throws Exception {
        int num1 = 0;
        int num2 = 0;
        String operator = "";

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (Character.isDigit(currentChar)) {
                if (num1 == 0) {
                    num1 = Character.getNumericValue(currentChar);
                } else {
                    num2 = Character.getNumericValue(currentChar);
                }
            } else if ("+-*/".contains(Character.toString(currentChar))) {
                operator += currentChar;
            }
        }
        if (operator.equals("/") && num2 == 0) {
            throw new Exception("Деление на ноль не разрешено.");
        }
        if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
            throw new Exception("Числа должны быть в диапазоне от 1 до 10 включительно.");
        }



        int result = 0;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            default:
                throw new Exception("Неподдерживаемая арифметическая операция.");
        }
        return String.valueOf(result);
    }
}
