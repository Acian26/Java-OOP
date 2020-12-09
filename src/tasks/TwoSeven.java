import java.util.Scanner;

public class TwoSeven {
    public static void main(String[] args) {
        System.out.print ("Введите начение: ");
        Scanner u1 = new Scanner(System.in);
        String  index = u1.nextLine();

        System.out.print ("Результат работы программы:  " + isValid(index));
    }
    public static boolean isValid(String index){
        int buf = 0;
        for (int i = 0; i < index.length(); i++) {
            if (!Character.isDigit(index.charAt(i)))
                buf++;
            else if (index.charAt(i) == ' ')
                buf++;
            else if (index.length() != 5)
                buf++;
        }
        return buf == 0;
    }
}
