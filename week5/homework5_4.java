package week5;
import java.util.*;
public class homework5_4 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.print("Input : ");
        String a = sc.nextLine();
        a = a.toLowerCase();

        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c== 'o' || c== 'u') {
                continue;
            }
            System.out.println("false");
            return;
        }
        System.out.println("true");
    }
}


