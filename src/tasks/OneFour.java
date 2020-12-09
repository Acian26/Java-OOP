import java.util.Scanner;
public class OneFour {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите значение prob: ");
        float a = in.nextFloat();
        System.out.print("Введите значение prize: ");
        int b = in.nextInt();
        System.out.print("Введите значение pay: ");
        int c = in.nextInt();
        System.out.print("Значение равно: " + profitableGamble(a,b,c));

    }
    static boolean profitableGamble(float prob, int prize, int pay){
        boolean bool = true;
        if (prob*prize>pay){
            bool = true;
        }
        if (prob*prize<pay){
            bool = false;
        }
        return bool;
    }
}
