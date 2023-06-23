import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String arithExpression = in.nextLine();

        try {
            String result = calc(arithExpression);
            System.out.println(result);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Программа принимает два числа от 1 до 10 включительно и один оператор");
        }
    }
    public static String calc(String input) throws Exception {
        String[] expressionToCalc = input.split(" ");
        String[] numbers = expressionToCalc;
        String[] romans = {"I","II","III","IV","V","VI","VII","VIII","IX","X"};
        List<String> romansList = Arrays.asList(romans);
        int result = 0;

        if(romansList.contains(expressionToCalc[0]) && romansList.contains(expressionToCalc[2])) {
            numbers[0] = romanToNumber(expressionToCalc[0]);
            numbers[1] = expressionToCalc[1];
            numbers[2] = romanToNumber(expressionToCalc[2]);
        }

        int a = Integer.parseInt(numbers[0]);
        int b = Integer.parseInt(numbers[2]);
        boolean isMathExp = numbers[1].equals("+") || numbers[1].equals("-") || numbers[1].equals("*") || numbers[1].equals("/");
        try{
            if ((a > 0 && a <= 10) && (b > 0 && b <= 10)) {
                if (numbers[1].equals("+") && numbers.length == 3) {
                    result = Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[2]);
                } else if (numbers[1].equals("-") && numbers.length == 3) {
                    result = Integer.parseInt(numbers[0]) - Integer.parseInt(numbers[2]);
                } else if (numbers[1].equals("*") && numbers.length == 3) {
                    result = Integer.parseInt(numbers[0]) * Integer.parseInt(numbers[2]);
                } else if (numbers[1].equals("/") && numbers.length == 3) {
                    result = Integer.parseInt(numbers[0]) / Integer.parseInt(numbers[2]);
                }  else if (!isMathExp) {
                    System.out.println("Строка не является математической операцией");
                } else if (!numbers[3].isEmpty()) {
                    System.out.println("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                }
            } else {
                System.out.println("Калькулятор должен принимать на вход числа от 1 до 10 включительно");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return Integer.toString(result);
    }

    private static String romanToNumber(String roman){
        return switch (roman) {
            case "I" -> "1";
            case "II" -> "2";
            case "III" -> "3";
            case "IV" -> "4";
            case "V" -> "5";
            case "VI" -> "6";
            case "VII" -> "7";
            case "VIII" -> "8";
            case "IX" -> "9";
            case "X" -> "10";
            default -> throw new InputMismatchException("Неверный формат");
        };
    }
}
