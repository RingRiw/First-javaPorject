package week5;
import java.util.*;
public class homework5_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = 0;

        System.out.print("Input a string : ");
        int num = sc.nextInt();

        for(int n = num; n>0; n/=10){
            a+= (n%10);
        }
        System.out.println("The sum is "+a);
    }
}
