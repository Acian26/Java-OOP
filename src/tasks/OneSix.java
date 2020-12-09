import java.util.Scanner;
public class OneSix {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите символ, который надо перевести в ASCII: ");
        String a = in.nextLine();
        System.out.print("ASCII символа равен: " + ctoa(a));

    }
    static int ctoa(String firstSymb){
        int ascii = firstSymb.toCharArray()[0];
        return ascii;
    }
}