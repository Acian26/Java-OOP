package tasks;

import java.util.Scanner;

public class ThreeNine {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Простое число: "+nextPrime(in));
    }
    public static int nextPrime (Scanner scanner) {
        System.out.println("Введите число для проверки на простоту: ");
        int res = 0;
        int number = scanner.nextInt();
        boolean checkPrime = false;
        if (number <= 2) { //Проверка на корректность введенных данных
            res = number; //Число является простым
        } else {
            for (int i = 3; i < Math.sqrt(number); ) { //Проверка числа на простоту
                if (number % i == 0) { //Если есть делитель нацело
                    break;
                } else {
                    i++;
                }
            }
            while (!checkPrime) {
                //Проверка до корня из числа с целью оптимизации быстродействия
                for (int i = 2; i < Math.sqrt(number) + 1; i++) {
                    if (number % i == 0) { //В случае наличия делителя помимо 1 и самого числа
                        number++;
                        break;
                    } else if (i > Math.sqrt(number)) { //В случае отсутствия делителей помимо 1 и самого числа
                        checkPrime = true; //Выход из цикла с условием
                        res = number; //Присвоение финального значения
                    }
                }
            }
        }
        return res;
    }
}
