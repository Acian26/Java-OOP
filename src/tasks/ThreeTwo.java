package tasks;

import java.util.Scanner;

public class ThreeTwo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(findZip(in));
    }
    public static int findZip (Scanner scanner) {
        System.out.println("Введите строку для поиска \"zip\" в ней: ");
        String inputString = scanner.nextLine();
        int index = 0; //Отрицательное значение для дальнейшего сравнения с индексом первого вхождения
        int first = inputString.indexOf("zip");
        int second = inputString.indexOf("zip", first + 1); //Нахождение второго вхождения
        if (second > first) { //Если есть два вхождения
            index = second;
        }
        return index - 1;
        //Увеличение на один возвращаемого значения, т.к. индексирование с нуля
    }
}
