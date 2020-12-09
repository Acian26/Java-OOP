import java.util.Scanner;
public class OneTwo {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите основание треугольника: ");
        int a = in.nextInt();
        System.out.print("Введите высоту треугольника: ");
        int b = in.nextInt();
        System.out.print("Площадь треугольника равна: " + triArea(a,b));

    }
    static int triArea(int firstNum, int secondNum){
        return firstNum*secondNum/2;
    }
}
