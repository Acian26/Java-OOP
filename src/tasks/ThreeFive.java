package tasks;

import java.util.Scanner;

public class ThreeFive {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print(isValidHexCode(in));
    }
    public static boolean isValidHexCode (Scanner scanner) {
        System.out.println("Введите строку для проверки на корректность шестнадцатеричного кода: ");
        String inputString = scanner.nextLine();
        return inputString.matches("^#[a-fA-F0-9]{6}$");
        //Возвращается логическое значение выражения с целью уменьшения списка временных переменных
    }
}
