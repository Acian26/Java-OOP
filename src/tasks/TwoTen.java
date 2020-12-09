import java.util.Scanner;

public class TwoTen {
    public static void main(String[] args) {
        System.out.print ("Введите число (шаг): ");
        Scanner p1 = new Scanner(System.in);
        int shag = p1.nextInt();

        System.out.println("Количество полей на этом шаге последовательности: " + boxSeq(shag));
    }
    public static int boxSeq(int shag){
        if (shag == 0) return 0;
        int count = 0;
        for (int i = 0; i < shag; i++) {
            if (i % 2 != 0) count--;
            else count += 3;
        }
        return count;
    }
}
