package tasks;

import java.util.Scanner;

public class ThreeFour {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(flipEndChars(in));
    }
    public static String flipEndChars (Scanner scanner) {
        System.out.println("Введите исходную строку: ");
        String inputString = scanner.nextLine();
        String result = null;
        char[] stringArray = inputString.toCharArray(); //Приведение строки к массиву символов для дальнейшего анализа
        //Проверка на выполнение условий задачи
        if (inputString.length() > 2 && stringArray[0] != stringArray[inputString.length() - 1]) {
            result = stringArray[inputString.length() - 1] +
                    inputString.substring(1, inputString.length() - 1)
                    + stringArray[0]; //Преобразование строки к требуемому виду
        } else if (inputString.length() <= 2) {
            result = "Длина строки не превышает двух символов.";
        } else if (stringArray[0] == stringArray[inputString.length() - 1]) {
            result = "Символы в начале и конце строки совпадают";
        }
        return result;
    }
}
