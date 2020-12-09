import java.util.Scanner;

public class OneTen {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Какое число будем складывать?: ");
        int a = in.nextInt();
        System.out.print("Сколько раз надо сложить?: ");
        int b = in.nextInt();
        System.out.print("Делимость на какое число надо проверить?: ");
        int c = in.nextInt();
        System.out.print("Значение равно: " + abcmath(a,b,c));

    }
    public static boolean abcmath(int a, int b, int c){
        for (int i = 0; i<b ; i++){
            a=a+a;
        }
        return a % c == 0;
    }
}
