package week5;

import java.util.Scanner;
public class homework5_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a;

        System.out.print("Input a string : ");
        a = sc.nextLine();

        int b = a.length()/2;

        System.out.println("The middle character in the string : "+a.charAt(b));
        sc.close();
    }
}
