import java.util.Scanner;
public class OneFive {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите число N: ");
        int a = in.nextInt();
        System.out.print("Введите число a: ");
        int b = in.nextInt();
        System.out.print("Введите число b: ");
        int c = in.nextInt();
        System.out.print("Возможное действие: " + operation(a,b,c));

    }
    static String operation(int one, int two, int three){
         String rezult = "";
         if (two+three==one) rezult = "сложить";
         else if (two-three==one) rezult = "вычесть";
         else if (two*three==one) rezult = "умножить";
         else if (two/three==one) rezult = "разделить";
         else rezult = "ни одно действие не подходит";
        return rezult;
    }
}
