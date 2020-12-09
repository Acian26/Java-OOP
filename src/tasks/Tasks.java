package tasks;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

class Module4 {
    public static String bessy(int n, int k, String str) {
        String[] text = str.split(" ");
        String line = "";
        String result = "";

        for (int i = 0; i < n; i++) {
            if (line.length() + text[i].length() > k) {
                result = result.trim() + "\r\n" + text[i] + " ";
                line = text[i];
            } else {
                result += text[i] + " ";
                line += text[i];
            }
        }

        return result.trim();
    }

    public static String[] split(String str) {
        List<String> list = new ArrayList<>();
        int f = 0;
        int i = 0;
        String string = str;

        while (string.length() > 0) {
            if (string.charAt(i) == '(') f++;
            else f--;

            if (f == 0) {
                list.add(string.substring(0, i + 1));
                string = string.substring(i + 1);
                i = 0;
                continue;
            }

            i++;
        }

        return list.toArray(new String[list.size()]);
    }

    public static String toCamelCase(String str) {
        String[] tokens = str.split("_");

        for (int i = 1; i < tokens.length; i++) {
            tokens[i] = Character.toUpperCase(tokens[i].charAt(0)) + tokens[i].substring(1);
        }

        return String.join("", tokens);
    }

    public static String toSnakeCase(String str) {
        return str.replaceAll("([A-Z])", "_$0").toLowerCase();
    }

    public static String overTime(double[] work) {
        double sum;

        if (work[1] <= 17) {
            sum = (work[1] - work[0]) * work[2];
        } else {
            sum = (17 - work[0]) * work[2] + (work[1] - 17) * work[2] * work[3];
        }

        return ('$' + String.valueOf(sum));
    }

    public static String BMI(String weight, String height) {
        double amountOfWeight = Double.parseDouble(weight.split(" ")[0]);
        double amountOfHeight = Double.parseDouble(height.split(" ")[0]);
        String out = " ";

        if (weight.contains("pounds"))
            amountOfWeight = amountOfWeight * 0.45;

        if (height.contains("inches"))
            amountOfHeight *= 0.0254;

        double BMI = Math.round((amountOfWeight / (amountOfHeight * amountOfHeight)) * 10.0) / 10.0;

        if (BMI < 18.5)
            out = BMI + " Underweight";

        if (BMI >= 18.5 && BMI <= 24.9)
            out = BMI + " Normal weight";

        if (BMI > 25)
            out = BMI + " Overweight";

        return out;
    }

    public static int bugger(int num) {
        int count = 0;
        int number = num;

        while (number > 9) {
            int chnum = 1;

            while (number > 0) {
                chnum *= number % 10;
                number /= 10;
            }

            number = chnum;
            count++;
        }

        return count;
    }

    public static String toStarShorthand(String str) {
        int count = 1;
        char let = str.charAt(0);
        String newStr = "";

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != let) {
                if (count != 1)
                    newStr += let + "*" + count;
                else
                    newStr += let;
                let = str.charAt(i);
                count = 1;
            } else
                count++;
        }

        if (count != 1)
            newStr += let + "*" + count;
        else
            newStr += let;

        return newStr;
    }

    public static boolean doesRhyme(String str1, String str2) {
        str1 = str1.substring(str1.lastIndexOf(" ") + 1);
        str2 = str2.substring(str2.lastIndexOf(" ") + 1);
        String let = "aeiouyAEIOUY";
        String res1 = "", res2 = "";

        for (int i = 0; i < str1.length(); i++) {
            if (let.indexOf(str1.charAt(i)) != -1)
                res1 += str1.charAt(i);
        }

        for (int i = 0; i < str2.length(); i++) {
            if (let.indexOf(str2.charAt(i)) != -1)
                res2 += str2.charAt(i);
        }

        return res1.equalsIgnoreCase(res2);
    }

    public static boolean trouble(long a, long b) {
        String aa = Long.toString(a);
        String bb = Long.toString(b);
        int num = 0;

        for (int i = 2; i < aa.length(); i++) {
            if (aa.charAt(i) == aa.charAt(i - 1) && aa.charAt(i) == aa.charAt(i - 2))
                num = aa.charAt(i);
        }

        for (int i = 0; i < bb.length(); i++) {
            if (bb.charAt(i) == num && bb.charAt(i + 1) == num)
                return true;
        }

        return false;
    }

    public static int countUniqueBooks(String str, char c) {
        Map<Character, Integer> values = new HashMap<>();
        boolean start = true;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c && start) {
                i++;

                while (str.charAt(i) != c) {
                    Integer n = values.get(str.charAt(i));

                    if (n == null) values.put(str.charAt(i), 1);

                    i++;
                }

                start = false;
            }

            if (str.charAt(i) == c)
                start = true;
        }

        return values.size();
    }
}

class Module5 {
    public static int[] encrypt(String str) {
        int length = str.length();
        int[] result = new int[length];
        result[0] = str.charAt(0);

        for (int i = 1; i < length; i++) {
            result[i] = str.charAt(i) - str.charAt(i - 1);
        }

        return result;
    }

    public static String decrypt(int[] arr) {
        int[] encoded = new int[arr.length];

        System.arraycopy(arr, 0, encoded, 0, arr.length);

        char[] result = new char[arr.length];

        result[0] = (char) arr[0];

        for (int i = 1; i < encoded.length; i++) {
            result[i] = (char) (encoded[i] + encoded[i - 1]);
            encoded[i] = encoded[i] + encoded[i - 1];
        }

        return new String(result);
    }

    public static boolean canMove(String name, String start, String end) {
        char startLetter = start.charAt(0);
        int startNumber = Integer.parseInt(String.valueOf(start.charAt(1)));
        char endLetter = end.charAt(0);
        int endNumber = Integer.parseInt(String.valueOf(end.charAt(1)));

        if (startLetter == endLetter && startNumber == endNumber) return false;

        switch (name) {
            case "Pawn": {
                if (startLetter == endLetter && startNumber == 2 && endNumber == 4)
                    return true;
                return startLetter == endLetter && endNumber == (startNumber + 1);
            }
            case "Knight": {
                return (Math.abs(startLetter - endLetter) == 2 && Math.abs(startNumber - endNumber) == 1) || (Math.abs(startLetter - endLetter) == 1 && Math.abs(startNumber - endNumber) == 2);
            }
            case "Bishop": {
                return Math.abs(startLetter - endLetter) == Math.abs(startNumber - endNumber);
            }
            case "Rook": {
                return (startLetter == endLetter && startNumber != endNumber) || (startLetter != endLetter && startNumber == endNumber);
            }
            case "Queen": {
                if ((startLetter == endLetter && startNumber != endNumber) || (startLetter != endLetter && startNumber == endNumber))
                    return true;
                if (Math.abs(startLetter - endLetter) == Math.abs(startNumber - endNumber))
                    return true;
                break;
            }
            case "King": {
                return Math.abs(startLetter - endLetter) < 2 && Math.abs(startNumber - endNumber) < 2;
            }
            default:
                return false;
        }

        return false;
    }

    public static boolean canComplete(String str1, String str2) {
        char[] chars = str1.toCharArray();
        int startOfSearch = 0;
        for (char c : chars) {
            if (str2.indexOf(String.valueOf(c), startOfSearch) != -1)
                startOfSearch = str2.indexOf(String.valueOf(c), startOfSearch) + 1;
            else
                return false;
        }
        return true;
    }

    public static int sumDigProd(int[] mass) {
        int sum = 0;

        for (int value : mass) {
            sum += value;
        }

        while (sum > 9) {
            int mult = 1;

            while (sum > 0) {
                mult *= sum % 10;
                sum /= 10;
            }

            sum = mult;
        }

        return sum;
    }

    public static ArrayList<String> sameVowelGroup(String[] strs) {
        String[] allVowels = new String[]{"a", "e", "y", "u", "i", "o"};
        String vowels = "";
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < allVowels.length; i++) {
            if (strs[0].contains(allVowels[i]) && !vowels.contains(allVowels[i])) {
                vowels += allVowels[i];
            }
        }

        if (vowels.length() > 0) {
            result.add(strs[0]);
        } else {
            return result;
        }

        for (int i = 1; i < strs.length; i++) {
            boolean pass = true;

            for (int j = 0; j < vowels.length(); j++) {
                if (!strs[i].contains(String.valueOf(vowels.charAt(j)))) {
                    pass = false;
                    break;
                }
            }

            if (pass) result.add(strs[i]);
        }

        return result;
    }

    public static boolean validateCard(long cardNum) {
        StringBuilder str = new StringBuilder();
        long number = cardNum;

        if (Long.toString(number).length() >= 14 && Long.toString(number).length() <= 19) {
            // step 1
            long lastNum = number % 10;
            StringBuilder cardNumStr = new StringBuilder(Long.toString(number /= 10));
            // step 2
            cardNumStr.reverse();
            // step 3
            for (int i = 0; i < cardNumStr.length(); i++) {
                if (i % 2 == 0) {
                    int c = Character.getNumericValue(cardNumStr.charAt(i)) * 2;

                    if (c > 9) {
                        String buf = Integer.toString(c);

                        str.append(Character.getNumericValue(buf.charAt(0)) + Character.getNumericValue(buf.charAt(1)));
                    } else {
                        str.append(c);
                    }
                } else {
                    str.append(cardNumStr.charAt(i));
                }
            }

            System.out.println(str);
            int sum = 0;

            for (int i = 0; i < str.length(); i++) {
                sum += Character.getNumericValue(str.charAt(i));
            }

            System.out.println(sum);
            System.out.println(lastNum);

            return lastNum == 10 - sum % 10;
        }

        return false;
    }

    public static String numToEng(int num) {
        String str = "";
        if (num == 0) return "zero";

        switch (num / 100) {
            case 1: {
                str += "one hundred ";
                break;
            }
            case 2: {
                str += "two hundred ";
                break;
            }
            case 3: {
                str += "three hundred ";
                break;
            }
            case 4: {
                str += "four hundred ";
                break;
            }
            case 5: {
                str += "five hundred ";
                break;
            }
            case 6: {
                str += "six hundred ";
                break;
            }
            case 7: {
                str += "seven hundred ";
                break;
            }
            case 8: {
                str += "eight hundred ";
                break;
            }
            case 9: {
                str += "nine hundred ";
                break;
            }
        }

        switch (num / 10 % 10) {
            case 1: {
                switch (num % 10) {
                    case 0: {
                        str += "ten";
                        return str;
                    }
                    case 1: {
                        str += "eleven";
                        return str;
                    }
                    case 2: {
                        str += "twelve";
                        return str;
                    }
                    case 3: {
                        str += "thirteen";
                        return str;
                    }
                    case 4: {
                        str += "fourteen";
                        return str;
                    }
                    case 5: {
                        str += "fifteen";
                        return str;
                    }
                    case 6: {
                        str += "sixteen";
                        return str;
                    }
                    case 7: {
                        str += "seventeen";
                        return str;
                    }
                    case 8: {
                        str += "eighteen";
                        return str;
                    }
                    case 9: {
                        str += "nineteen";
                        return str;
                    }
                }
            }

            case 2: {
                str += "twenty ";
                break;
            }
            case 3: {
                str += "thirty ";
                break;
            }
            case 4: {
                str += "forty ";
                break;
            }
            case 5: {
                str += "fifty ";
                break;
            }
            case 6: {
                str += "sixty ";
                break;
            }
            case 7: {
                str += "seventy ";
                break;
            }
            case 8: {
                str += "eighty ";
                break;
            }
            case 9: {
                str += "ninety ";
                break;
            }
        }

        switch (num % 10) {
            case 1: {
                str += "one";
                break;
            }
            case 2: {
                str += "two";
                break;
            }
            case 3: {
                str += "three";
                break;
            }
            case 4: {
                str += "four";
                break;
            }
            case 5: {
                str += "five";
                break;
            }
            case 6: {
                str += "six";
                break;
            }
            case 7: {
                str += "seven";
                break;
            }
            case 8: {
                str += "eight";
                break;
            }
            case 9: {
                str += "nine";
                break;
            }
        }

        return str;
    }

    public static String numToRus(int num) {
        String str = "";

        if (num == 0) return "ноль";

        switch (num / 100) {
            case 1: {
                str += "сто ";
                break;
            }
            case 2: {
                str += "двести ";
                break;
            }
            case 3: {
                str += "триста ";
                break;
            }
            case 4: {
                str += "четыреста ";
                break;
            }
            case 5: {
                str += "пятьсот ";
                break;
            }
            case 6: {
                str += "шестьсот ";
                break;
            }
            case 7: {
                str += "семьсот ";
                break;
            }
            case 8: {
                str += "восемьсот ";
                break;
            }
            case 9: {
                str += "девятьсот ";
                break;
            }
        }

        switch (num / 10 % 10) {
            case 1: {
                switch (num % 10) {
                    case 0: {
                        str += "десять";
                        return str;
                    }
                    case 1: {
                        str += "одиннадцать";
                        return str;
                    }
                    case 2: {
                        str += "двенадцать";
                        return str;
                    }
                    case 3: {
                        str += "тринадцать";
                        return str;
                    }
                    case 4: {
                        str += "четырнадцать";
                        return str;
                    }
                    case 5: {
                        str += "пятнадцать";
                        return str;
                    }
                    case 6: {
                        str += "шестнадцать";
                        return str;
                    }
                    case 7: {
                        str += "семнадцать";
                        return str;
                    }
                    case 8: {
                        str += "восемьнадцать";
                        return str;
                    }
                    case 9: {
                        str += "двадцать";
                        return str;
                    }
                }
            }

            case 2: {
                str += "двадцать ";
                break;
            }
            case 3: {
                str += "тридцать ";
                break;
            }
            case 4: {
                str += "сорок ";
                break;
            }
            case 5: {
                str += "пятьдесят ";
                break;
            }
            case 6: {
                str += "шестьдесят ";
                break;
            }
            case 7: {
                str += "семьдесят ";
                break;
            }
            case 8: {
                str += "восемьдесят ";
                break;
            }
            case 9: {
                str += "девяносто ";
                break;
            }
        }

        switch (num % 10) {
            case 1: {
                str += "один";
                break;
            }
            case 2: {
                str += "два";
                break;
            }
            case 3: {
                str += "три";
                break;
            }
            case 4: {
                str += "четыре";
                break;
            }
            case 5: {
                str += "пять";
                break;
            }
            case 6: {
                str += "шесть";
                break;
            }
            case 7: {
                str += "семь";
                break;
            }
            case 8: {
                str += "восемь";
                break;
            }
            case 9: {
                str += "девять";
                break;
            }
        }

        return str;
    }

    public static String getSha256Hash(String str) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] text = digest.digest(str.getBytes(StandardCharsets.UTF_8));

        return HexBin.encode(text).toLowerCase();
    }

    public static String correctTitle(String str) {
        String[] tokens = str.split(" ");

        for (int i = 0; i < tokens.length; i++) {
            if (!tokens[i].equalsIgnoreCase("of") && !tokens[i].equalsIgnoreCase("and") && !tokens[i].equalsIgnoreCase("the") && !tokens[i].equalsIgnoreCase("in")) {
                tokens[i] = String.valueOf(tokens[i].charAt(0)).toUpperCase() + tokens[i].substring(1).toLowerCase();
            } else {
                tokens[i] = tokens[i].toLowerCase();
            }
        }

        return String.join(" ", tokens);
    }

    public static String hexLattice(int n) {
        int num = 1;
        int i = 1;
        String res = "";
        String str2 = "";

        while (n > num) {
            i++;
            num = 3 * i * (i - 1) + 1;
        }

        int l = i;

        if (n != num)
            res = "invalid";
        else {
            while (l < i * 2 - 1) {

                for (int a = 0; a < i * 2 - 1 - l; a++)
                    res += "  ";

                for (int b = 0; b < l; b++)
                    res += " o  ";

                res += "\n";
                l++;
            }

            while (l >= i) {

                for (int a = 0; a < i * 2 - 1 - l; a++)
                    res += "  ";

                for (int b = l; b > 0; b--)
                    res += " o  ";

                res += "\n";
                l--;
            }
        }

        return res;
    }
}

class Module6 {
    public static int bell(int n) {
        int[][] bellTriangle = new int[n+1][n+1];
        bellTriangle[0][0] = 1;

        for (int i=1; i<=n; i++) {
            bellTriangle[i][0] = bellTriangle[i-1][i-1];

            for (int j=1; j<=i; j++) {
                bellTriangle[i][j] = bellTriangle[i-1][j-1] + bellTriangle[i][j-1];
            }
        }

        return bellTriangle[n][0];
    }

    public static String translateWord(String word) {
        String result = word;

        if (String.valueOf(result.charAt(0)).toLowerCase().matches("[aeiouy]")) {
            result += "yay";
        } else {
            result = result.toLowerCase();
            String newWord = result.split("[aeiouy]")[0];
            result = result.replaceFirst(newWord,"") + newWord + "ay";
            result = String.valueOf(result.charAt(0)).toUpperCase() + result.substring(1);
        }

        return result;
    }

    public static String translateSentence(String str) {
        String[] tokens = str.split(" ");

        for (int i = 0; i < tokens.length; i++) {
            if (String.valueOf(tokens[i].charAt(0)).toLowerCase().matches("[aeiouy]")) {
                if (String.valueOf(tokens[i].charAt(tokens[i].length() - 1)).matches("[!?.,:;]")) {
                    tokens[i] = tokens[i].substring(0, tokens[i].length() - 1) + "yay" + tokens[i].charAt(tokens[i].length() - 1);
                } else {
                    tokens[i] += "yay";
                }
            } else {
                if (String.valueOf(tokens[i].charAt(0)).matches("[QWRTPSDFGHJKLZXCVBNM]")) {
                    if (String.valueOf(tokens[i].charAt(tokens[i].length() - 1)).matches("[!?.,:;]")) {
                        char mark = tokens[i].charAt(tokens[i].length() - 1);
                        tokens[i] = tokens[i].substring(0, tokens[i].length() - 1);
                        tokens[i] = tokens[i].toLowerCase();
                        String newWord = tokens[i].split("[aeiouy]")[0];
                        tokens[i] = tokens[i].replaceFirst(newWord,"") + newWord + "ay";
                        tokens[i] = String.valueOf(tokens[i].charAt(0)).toUpperCase() + tokens[i].substring(1) + mark;
                    } else {
                        tokens[i] = tokens[i].toLowerCase();
                        String newWord = tokens[i].split("[aeiouy]")[0];
                        tokens[i] = tokens[i].replaceFirst(newWord,"") + newWord + "ay";
                        tokens[i] = String.valueOf(tokens[i].charAt(0)).toUpperCase() + tokens[i].substring(1);
                    }
                } else {
                    if (String.valueOf(tokens[i].charAt(tokens[i].length() - 1)).matches("[!?.,:;]")) {
                        char mark = tokens[i].charAt(tokens[i].length() - 1);
                        tokens[i] = tokens[i].substring(0, tokens[i].length() - 1);
                        tokens[i] = tokens[i].toLowerCase();
                        String newWord = tokens[i].split("[aeiouy]")[0];
                        tokens[i] = tokens[i].replaceFirst(newWord,"") + newWord + "ay";
                        tokens[i] = tokens[i] + mark;
                    } else {
                        tokens[i] = tokens[i].toLowerCase();
                        String newWord = tokens[i].split("[aeiouy]")[0];
                        tokens[i] = tokens[i].replaceFirst(newWord,"") + newWord + "ay";
                    }
                }
            }
        }

        return String.join(" ", tokens);
    }

    public static boolean validColor(String str) {
        if (!str.startsWith("rgb") && !str.startsWith("rgba")) {
            return false;
        }

        String[] numbers = str.split("\\(")[1].split(",");
        numbers[numbers.length - 1] = numbers[numbers.length - 1].substring(0, numbers[numbers.length - 1].length() - 1);

        if (str.startsWith("rgb") && !str.startsWith("rgba")) {
            if (str.contains(".")) {
                return false;
            }

            for (int i = 0; i < numbers.length; i ++) {
                if (numbers[i].trim().equals("")) {
                    return false;
                }

                int num = Integer.parseInt(numbers[i].trim());

                if (!(num >= 0 && num <= 255)) {
                    return false;
                }
            }
        } else {
            for (int i = 0; i < numbers.length - 1; i ++) {
                if (numbers[i].trim().equals("")) {
                    return false;
                }

                int num = Integer.parseInt(numbers[i].trim());

                if (!(num >= 0 && num <= 255)) {
                    return false;
                }
            }

            if (numbers[3].trim().equals("")) return false;

            double num = Double.parseDouble(numbers[3].trim());

            return num >= 0 && num <= 1;
        }

        return true;
    }

    public static String stripUrlParams(String url, String ...paramsToStrip) {
        String str = "";

        if (!url.contains("?"))
            return url;
        else {
            str = url.substring(url.indexOf("?") + 1);
            url = url.substring(0, url.indexOf("?") + 1);
        }

        char[] params = str.toCharArray();
        StringBuilder print = new StringBuilder();

        for (char param : params) {
            if (Character.isLetter(param))
                if (!(print.toString().contains(String.valueOf(param)))) {
                    if (paramsToStrip.length > 0) {
                        for (String arg : paramsToStrip) {
                            if (!(arg.contains(String.valueOf(param))))
                                print.append(str, str.lastIndexOf(param), str.lastIndexOf(param) + 3).append("&");
                        }
                    }
                    else
                        print.append(str, str.lastIndexOf(param), str.lastIndexOf(param) + 3).append("&");
                }
        }

        return url + print.substring(0, print.length()-1);
    }

    public static ArrayList<String> getHashTags(String str){
        String[] tokens = str.toLowerCase().split(" ");
        ArrayList<String> hashtags = new ArrayList<>();

        while (hashtags.size() < 3) {
            double maxLength = Double.NEGATIVE_INFINITY;
            String word = "";
            int idx = 0;

            try {
                for (int i = 0; i < tokens.length; i++) {
                    if (tokens[i].length() > maxLength) {
                        maxLength = tokens[i].length();
                        word = tokens[i];
                        idx = i;
                    }
                }

                if (String.valueOf(word.charAt(word.length() - 1)).matches("[!?.,;:]")) {
                    hashtags.add("#" + word.substring(0, word.length() - 1));
                } else {
                    hashtags.add("#" + word);
                }
                tokens[idx] = "";
            } catch (StringIndexOutOfBoundsException e) {
                return hashtags;
            }
        }

        return hashtags;
    }

    public static int ulam (int n){
        int[] arr = new int[n];
        arr[0]=1;
        arr[1]=2;
        int len=2, next=3;

        while (next < Integer.MAX_VALUE && len < n){
            int count = 0;

            for (int i = 0; i < len; i++){
                for (int j = len-1; j > i; j--){
                    if (arr[i] + arr[j] == next && arr[i] != arr[j])
                        count++;
                    else if (count > 1)
                        break;
                }

                if (count > 1)
                    break;
            }
            if (count == 1) {
                arr[len] = next;
                len++;
            }
            next++;
        }
        return arr[n-1];
    }

    public static String longestNonrepeatingSubstring(String str){
        String substr = "";
        char [] chars = str.toCharArray();
        StringBuilder builder = new StringBuilder();

        for (char c : chars) {
            if (!builder.toString().contains(String.valueOf(c)))
                builder.append(c);
            else {
                if (builder.length() > substr.length()) {
                    substr = builder.toString();
                }
                builder = new StringBuilder("" + c);
            }
        }

        str = builder.toString();

        if (str.length() > substr.length())
            substr = str;

        return substr;
    }

    public static String convertToRoman (int num){
        StringBuilder roman = new StringBuilder();

        if (num < 1 || num > 3999)
            return "Введите число поменьше. ";

        while (num >= 1000) {
            roman.append("M");
            num -= 1000;
        }

        while (num >= 900) {
            roman.append("CM");
            num -= 900;
        }

        while (num >= 500) {
            roman.append("D");
            num -= 500;
        }

        while (num >= 400) {
            roman.append("CD");
            num -= 400;
        }

        while (num >= 100) {
            roman.append("C");
            num -= 100;
        }

        while (num >= 90) {
            roman.append("XC");
            num -= 90;
        }

        while (num >= 50) {
            roman.append("L");
            num -= 50;
        }

        while (num >= 40) {
            roman.append("XL");
            num -= 40;
        }

        while (num >= 10) {
            roman.append("X");
            num -= 10;
        }

        while (num >= 9) {
            roman.append("IX");
            num -= 9;
        }

        while (num >= 5) {
            roman.append("V");
            num -= 5;
        }

        while (num >= 4) {
            roman.append("IV");
            num -= 4;
        }

        while (num >= 1) {
            roman.append("I");
            num -= 1;
        }

        return roman.toString();
    }

    public static boolean formula(String formula){
        String[] tokens = formula.split(" ");
        int ans = 0;
        int expectedResult = 0;

        if (!Character.isDigit(tokens[0].charAt(0))) return false;
        else ans = Integer.parseInt(tokens[0]);

        int i = 1;

        while (!tokens[i].equals("=")) {
            if (tokens[i].equals("+")){
                ans += Integer.parseInt(tokens[i + 1]);
            }
            if (tokens[i].equals("-")){
                ans -= Integer.parseInt(tokens[i + 1]);
            }
            if (tokens[i].equals("*")){
                ans *= Integer.parseInt(tokens[i + 1]);
            }
            if (tokens[i].equals("/")){
                ans /= Integer.parseInt(tokens[i + 1]);
            }

            i += 2;
        }

        i = formula.indexOf('=');
        String check = formula.substring(i + 1);

        if (check.contains("=")) return false;
        else expectedResult = Integer.parseInt(tokens[tokens.length - 1]);

        return ans == expectedResult;
    }

    public static boolean palindromedescendant(int num){
        boolean isDescendant = false;
        StringBuffer buffer1 =new StringBuffer(num);
        StringBuffer buffer2 =new StringBuffer(num);

        if (buffer1.length() % 2 != 0)
            return false;
        else {
            while (!isDescendant){
                if(buffer1 != buffer1.reverse()){
                    for(int i = 0; i < buffer1.length(); i += 2){
                        int a = Integer.parseInt(String.valueOf(buffer1.charAt(i)));
                        int b = Integer.parseInt(String.valueOf(buffer1.charAt(i + 1)));
                        buffer2.append(a + b);
                    }
                }
                else
                    isDescendant = true;
            }
        }

        return isDescendant;
    }
}

class Tasks {
    public static void log(String str) {
        System.out.println(str);
    }

    public static void log(double str) {
        System.out.println(str);
    }

    public static void log(boolean str) {
        System.out.println(str);
    }

    public static void log(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void log(String[] str) {
        System.out.println(String.join(" ", str));
    }

    public static void log(ArrayList<String> arr) {
        System.out.println(Arrays.toString(arr.toArray()));
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        log("===================================");
        log("Модуль 4");
        log("===================================");
        log("4.1");
        log(Module4.bessy(10, 7, "hello my name is Bessie and this is my essay"));
        log("_____");
        log("4.2");
        log(Module4.split("((()))(())()()(()())"));
        log("_____");
        log("4.3");
        log(Module4.toCamelCase("hello_edabit"));
        log(Module4.toSnakeCase("helloEdabit"));
        log("_____");
        log("4.4");
        log(Module4.overTime(new double[]{16, 18, 30, 1.8}));
        log("_____");
        log("4.5");
        log(Module4.BMI("55 kilos", "1.65 meters"));
        log("_____");
        log("4.6");
        log(Module4.bugger(39));
        log("_____");
        log("4.7");
        log(Module4.toStarShorthand("abbccc"));
        log("_____");
        log("4.8");
        log(Module4.doesRhyme("Sam I am!", "Green eggs and ham."));
        log("_____");
        log("4.9");
        log(Module4.trouble(451997772, 411779228));
        log("_____");
        log("4.10");
        log(Module4.countUniqueBooks("$AA$BBCATT$C$$B$", '$'));
        log("===================================");
        log("Модуль 5");
        log("===================================");
        log("5.1");
        log(Module5.encrypt("Hello"));
        log(Module5.decrypt(new int[]{72, 33, -73, 84, -12, -3, 13, -13, -68}));
        log("_____");
        log("5.2");
        log(Module5.canMove("Rook", "A8", "H8"));
        log("_____");
        log("5.3");
        log(Module5.canComplete("butl", "beautiful"));
        log("_____");
        log("5.4");
        log(Module5.sumDigProd(new int[]{16, 28}));
        log("_____");
        log("5.5");
        log(Module5.sameVowelGroup(new String[]{"hoops", "chuff", "bot", "bottom"}));
        log("_____");
        log("5.6");
        log(Module5.validateCard(1234567890123452L));
        log("_____");
        log("5.7");
        log(Module5.numToEng(18));
        log(Module5.numToRus(18));
        log("_____");
        log("5.8");
        log(Module5.getSha256Hash("password123"));
        log("_____");
        log("5.9");
        log(Module5.correctTitle("TYRION LANNISTER, HAND OF THE QUEEN."));
        log("_____");
        log("5.10");
        log(Module5.hexLattice(19));
        log("===================================");
        log("Модуль 6");
        log("===================================");
        log("6.1");
        log(Module6.bell(5));
        log("_____");
        log("6.2");
        log(Module6.translateWord("Do"));
        log(Module6.translateSentence("I like to eat honey waffles."));
        log("_____");
        log("6.3");
        log(Module6.validColor("rgba(0,0,0,0.123456789)"));
        log("_____");
        log("6.4");
        log(Module6.stripUrlParams("https://edabit.com", "b"));
        log("_____");
        log("6.5");
        log(Module6.getHashTags("Visualizing Science"));
        log("_____");
        log("6.6");
        log(Module6.ulam(206));
        log("_____");
        log("6.7");
        log(Module6.longestNonrepeatingSubstring("abcabcbb"));
        log("_____");
        log("6.8");
        log(Module6.convertToRoman(16));
        log("_____");
        log("6.9");
        log(Module6.formula("6 * 4 = 24"));
        log("_____");
        log("6.10");
        log(Module6.palindromedescendant(11211230));
    }
}