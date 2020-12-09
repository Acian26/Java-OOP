package tasks;

import java.util.Scanner;

public class ThreeTen {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(rightTriangle(in));
    }
    public static boolean rightTriangle (Scanner scanner) {
        System.out.println("Введите a, b, c - длины сторон треугольника: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        return Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2) ||
                Math.pow(b, 2) + Math.pow(c, 2) == Math.pow(a, 2) ||
                Math.pow(a, 2) + Math.pow(c, 2) == Math.pow(b, 2);
        //Возвращается логическое значение выражения с целью уменьшения списка временных переменных
    }
}
