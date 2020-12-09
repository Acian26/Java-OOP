import java.util.Scanner;
public class OneOne {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите 1 число: ");
        int a = in.nextInt();
        System.out.print("Введите 2 число: ");
        int b = in.nextInt();
        System.out.print("Остаток от деления равен: " + reminder(a,b));

    }
    static int reminder(int firstNum, int secondNum){
        return firstNum%secondNum;
    }
}