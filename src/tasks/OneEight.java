import java.util.Scanner;

public class OneEight {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите длину 1 стороны: ");
        Integer a = in.nextInt();
        System.out.print("Введите длину 2 стороны: ");
        Integer b = in.nextInt();
        System.out.print("Максимальная длина третьей стороны равна: " + nextEdge(a,b));
    }
    public static int nextEdge(int a, int b){
        return a + b -1;
    }
}