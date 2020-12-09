import java.util.Scanner;
public class TwoOne {
    public static void main(String[] args){
        System.out.print ("Введите слово: ");
        Scanner s1 = new Scanner(System.in);
        String word = s1.nextLine();

        System.out.print ("Введите сколько раз повторять буквы: ");
        Scanner s2 = new Scanner(System.in);
        int n = s2.nextInt();

        System.out.print ("Результат работы программы = "+ repeat(word, n));
    }
    public static String repeat(String word, int n){
        String newWord = " ";
        for (int i = 0; i< word.length() ; i++){
            for (int j = 0; j<n; j++){
                newWord+= word.charAt(i);
            }
        }
        return newWord;
    }
}
