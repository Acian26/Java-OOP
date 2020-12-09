import java.util.Scanner;
public class TwoTwo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Объявляем Scanner
        System.out.print("Введите размерность массива: ");
        int size = input.nextInt();
        int[] mass = new int[size]; // Создаём массив int размером в size
        System.out.print("Введите числа в массив: ");
        for (int i = 0; i < size; i++) {
            mass[i] = input.nextInt(); // Заполняем массив элементами, введёнными с клавиатуры
        }
        System.out.print("Результат работы программы = " + differenceMaxMin(mass));
    }

    public static int differenceMaxMin(int[] mass) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int value : mass) {
            min = Math.min(min, value);
            max = Math.max(max, value);
        }
        return max - min;
    }
}
