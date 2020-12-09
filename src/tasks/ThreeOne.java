package tasks;

import java.util.Scanner;

public class ThreeOne {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(solutions(in));
    }
    public static String solutions (Scanner scanner) {
        System.out.println("Введите коэффициенты a, b, c для уравнения ax^2 + bx + c = 0: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        String res = "Уравнение " + a + "x^2+" + b + "x+" + c + "=0 "; //Создание общей части строки для дальнейшего вывода
        double discr = Math.pow(b, 2) - 4 * a * c; //Нахождение дискриминанта уравнения
        double mean1;
        double mean2;
        //Нахождение корней уравнения в зависимости от значения дискриминанта
        if (discr > 0) {
            //System.out.println(discr);
            mean1 = (-b + Math.sqrt(discr)) / (2 * a);
            mean2 = (-b - Math.sqrt(discr) / (2 * a));
            res += "имеет два корня: " + mean1 + " и " + mean2;
        } else {
            if (discr == 0) {
                mean1 = (double) -b / (2 * a);
                res += "имеет один корень: " + mean1;
            } else {
                res += "не имеет корней";
            }
        }
        return res;
    }
}