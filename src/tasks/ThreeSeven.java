package tasks;
import java.util.Scanner;

public class ThreeSeven {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(isKaprekar (in));
    }

    public static boolean isKaprekar (Scanner scanner) {
        System.out.println("Введите число: ");
        int number = scanner.nextInt();
        boolean res;
        int countDigits = 1;
        double square = Math.pow(number, 2);
        int part1;
        int part2;
        if (Math.log10(square) < 1) {
            res = square == number;
        } else {
            double temp = square;
            while (temp > 10) {
                temp /= 10;
                countDigits++;
            }
            if (countDigits % 2 == 0) {
                part1 = (int) (square / Math.pow(10, countDigits / 2));
                part2 = (int) (square % Math.pow(10, countDigits / 2));
            } else {
                part1 = (int) (square / Math.pow(10, (countDigits + 1) / 2));
                part2 = (int) (square % Math.pow(10, (countDigits + 1) / 2));
            }
            res = part1 + part2 == number;
        }
        return res;
    }
}
