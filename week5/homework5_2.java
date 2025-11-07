package week5;
import java.util.*;
public class homework5_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input the string : ");
        String a = sc.nextLine();
        a = a.toLowerCase();
        int b = 0;

        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c== 'o' || c== 'u') {
                b++;
            }
        }
        System.out.println("Number of Vowels in the string : "+b);
    }
}
