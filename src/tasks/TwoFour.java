import java.util.Arrays;
import java.util.Scanner;

public class TwoFour {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print ("Введите размерность массива: ");
        int size2 = inp.nextInt();
        int[] mass2 = new int[size2];
        System.out.print ("Введите числа в массив: ");
        for (int i = 0; i < size2; i++) {
            mass2[i] = inp.nextInt();
        }
        System.out.print("Результат работы программы = " + Arrays.toString(cumulativeSum(mass2)));
    }

    public static int[] cumulativeSum( int [] mass){

        for (int i = 1; i < mass.length; i++){
            mass[i] = mass[i] + mass[i-1];
        }
        return mass;
    }
}
