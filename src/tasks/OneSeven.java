import java.util.Scanner;
public class OneSeven {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите число, сумму до которого надо посчитать: ");
        Integer a = in.nextInt();
        System.out.print("Сумма чисел равна: " + addUpTo(a));

    }
    static int addUpTo(Integer n){
        int sum = 0;
        for (int i = 1; i<=n; i++){
            sum = sum + i;
        }
        return sum;
    }
}