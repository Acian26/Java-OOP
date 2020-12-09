import java.util.Scanner;

public class TwoNine {
    public static void main(String[] args) {
        System.out.print ("Введите слово: ");
        Scanner o1 = new Scanner(System.in);
        String  wordpref = o1.nextLine();
        System.out.print ("Введите префикс/суффикс: ");
        Scanner o2 = new Scanner(System.in);
        String  pref = o2.nextLine();
        System.out.println ("Префикс?: " + isPrefix (wordpref,pref));
        System.out.print ("Суффикс?: " + isSuffix (wordpref,pref));
     }
    public static boolean isPrefix (String word, String pref){
        pref =  pref.substring(0,  pref.length()-1);
        return word.startsWith(pref);
    }
    public static boolean isSuffix (String word, String suf){
        suf = suf.substring(1);
        return word.endsWith(suf);
    }
}
