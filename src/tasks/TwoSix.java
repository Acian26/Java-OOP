import java.util.Scanner;

public class TwoSix {
    public static void main(String[] args) {
        System.out.print("Введите значение: ");
        Scanner y1 = new Scanner(System.in);
        int n1 = y1.nextInt();
        System.out.print("Число Фибоначчи равно: " + Fibonacci(n1));
    }

    public static int Fibonacci(int n) {
        switch (n) {
            case 0:
            case 1:
                return 1;
            default:
                return Fibonacci(n - 2) + Fibonacci(n - 1);
        }
    }
}
