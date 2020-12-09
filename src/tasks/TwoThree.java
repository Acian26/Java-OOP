import java.util.Scanner;
public class TwoThree {
    public static void main(String[] args) {
        Scanner input1 = new Scanner(System.in);
        System.out.print("Введите размерность массива: ");
        int size1 = input1.nextInt();
        int[] mass1 = new int[size1]; // Создаём массив int размером в size
        System.out.print("Введите числа в массив: ");
        for (int i = 0; i < size1; i++) {
            mass1[i] = input1.nextInt(); // Заполняем массив элементами, введёнными с клавиатуры
        }
        System.out.print("Результат работы программы = " + isAvgWhole(mass1));
    }

    public static boolean isAvgWhole(int mass[]) {
        double sum = 0;
        for (int value : mass) {
            sum += value;
        }
        if ((sum % mass.length) % 100 < 1)
            return true;
        else
            return false;
    }
}
