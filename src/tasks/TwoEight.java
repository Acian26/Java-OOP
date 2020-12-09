package tasks;
import java.util.Scanner;

public class TwoEight {
    public static void main(String[] args) {
        System.out.print ("Введите строку ");
        Scanner i1 = new Scanner(System.in);
        System.out.println("Результат: " + isStrangePair (i1));
    }
    public static boolean isStrangePair (Scanner scanner) {
        System.out.println("\nЗадача 2.8\nВведите две строки для их изучения: ");
        String string1 = scanner.nextLine();
        String string2 = scanner.nextLine();
        boolean res; //Инициализация переменной для дальнейшего возвращения
        //Сравнение элементов строки, приведенной к массиву символов
        if (!(string1.isBlank() && string2.isBlank())) {
            res = (string1.charAt(string1.length() - 1) == string2.charAt(0));
        } else {
            res = string1.isBlank() && string2.isBlank();
        }
        return res;
    }
}
