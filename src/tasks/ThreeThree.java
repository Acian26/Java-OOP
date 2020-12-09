package tasks;
import java.util.Scanner;

public class ThreeThree {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(checkPerfect(in));
    }
    public static boolean checkPerfect (Scanner scanner) {
        System.out.println("Введите число для проверки на совершенность: ");
        int number = scanner.nextInt();
        int sum = 0;
        boolean res = false; //Задания стандартно ложного значения переменной
        for (int counter = 1; counter <= number - 2; counter++) {
            if (number % counter == 0) {
                sum += counter;
            }
            if (sum == number)
                res = true;
        }
        return res;
    }
}
