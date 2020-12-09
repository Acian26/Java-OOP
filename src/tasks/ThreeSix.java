package tasks;

import java.util.Scanner;

public class ThreeSix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(same(in));
    }

    public static boolean same (Scanner scanner) {
        int count1 = 0;
        int count2 = 0;
        System.out.println("Введите количество элементов первого массива и эти элементы: ");
        int size1 = scanner.nextInt();
        int[] array1 = new int[size1]; //Создание массива пользовательского размера
        for (int pos = 0; pos < size1; pos++) {
            array1[pos] = scanner.nextInt(); //Заполнение массива
        }
        System.out.println("Введите количество элементов второго массива и эти элементы: ");
        int size2 = scanner.nextInt();
        int[] array2 = new int[size2];
        for (int pos = 0; pos < size2; pos++) {
            array2[pos] = scanner.nextInt();
        }
        for (int pos = 0; pos < size1; pos++) {
            count1++; //Увеличение счетчика на каждом элементе
            for (int pos1 = 0; pos1 < pos; pos1++) {
                if (array1[pos] == array1[pos1]) {
                    count1--; //Уменьшение счетчика на неуникальном элементе
                    break;
                }
            }
        }
        for (int pos = 0; pos < size2; pos++) {
            count2++;
            for (int pos1 = 0; pos1 < pos; pos1++) {
                if (array2[pos] == array2[pos1]) {
                    count2--;
                    break;
                }
            }
        }
        return count1 == count2;
        //Возвращается логическое значение выражения с целью уменьшения списка временных переменных
    }
}
