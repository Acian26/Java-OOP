package tasks;
import java.util.Scanner;

public class ThreeEight {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(longestZero (in));
    }

    public static String longestZero (Scanner scanner) {
        System.out.println("Введите строку для поиска длиннейшей последовательности нулей: ");
        String inputString = scanner.nextLine();
        int count = 0;
        int bestCount = 0;
        StringBuilder res = new StringBuilder();
        char[] charArray = inputString.toCharArray();
        for (int counter = 0; counter < charArray.length; counter++){
            if (charArray[counter] == '0'){
                count++;
            }
            if (counter + 1 == charArray.length || charArray[counter] != '0'){
                if (count > bestCount){
                    bestCount = count;
                }
                count = 0;
            }
        }
        if (bestCount > 0){
            res.append("0".repeat(bestCount));
        } else {
            res.append("Ни одного нуля в строке");
        }
        return res.toString();
    }
}
