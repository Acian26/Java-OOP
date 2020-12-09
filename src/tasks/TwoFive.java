import java.util.Scanner;

public class TwoFive {
    public static void main(String[] args) {
        System.out.println("Введите число: ");
        Scanner r1 = new Scanner(System.in);
        String number1 = r1.nextLine();
        System.out.println("Сколько знаков после точки?: " + getDecimalPlaces(number1));
    }
    public static int getDecimalPlaces(String number){
        if (number.indexOf('.') == -1){
            return 0;
        }
        else
            return number.length() - number.indexOf('.')-1;
    }
}