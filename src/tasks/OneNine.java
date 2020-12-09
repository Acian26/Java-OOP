import java.util.Scanner;

public class OneNine {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите длину массива: ");
        int size = in.nextInt(); // Читаем с клавиатуры размер массива и записываем в size
        int array[] = new int[size]; // Создаём массив int размером в size
        System.out.print("Введите элементы массива:");
        for (int i = 0; i < size; i++) {
            array[i] = in.nextInt(); // Заполняем массив элементами, введёнными с клавиатуры
        }
        for (int i = 0; i < size; i++) {
            System.out.print (" " + array[i] + " "); // Выводим на экран, полученный массив
        }
        System.out.print("Сумма кубов равна: " + sumOfCubes(array));

    }
    public static int sumOfCubes(int [] mass){
        int sum = 0;
        for (int value : mass) {
            sum += Math.pow(value, 3);
        }
        return sum;
    }
}
