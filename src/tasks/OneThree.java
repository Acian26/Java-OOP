import java.util.Scanner;
public class OneThree {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество куриц: ");
        int a = in.nextInt();
        System.out.print("Введите количество коров: ");
        int b = in.nextInt();
        System.out.print("Введите количество свиней: ");
        int c = in.nextInt();
        System.out.print("Количество ног на ферме равно: " + animals(a,b,c));

    }
    static int animals(int firstNum, int secondNum, int thirdNum){
        return firstNum*2+secondNum*4+thirdNum*4;
    }
}
