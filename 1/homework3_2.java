import java.util.Scanner;
public class homework3_2{
    public static void main(String[]agrs){
        Scanner sc = new Scanner(System.in);

        int x,y,temp = 0;

        System.out.print("Input x : ");
        x = sc.nextInt();

        System.out.print("Input y : ");
        y = sc.nextInt();

        System.out.println("X : "+x);
        System.out.println("Y : "+y);
        
        temp = x;
        x=y;
        y=temp;

        System.out.println("X : "+x);
        System.out.println("Y : "+y);
    }

    
}