import java.util.Scanner;
public class homework4_5 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        int choice;
        
        System.out.println("1.Traingle");
        System.out.println("2.Square");
        System.out.println("3.Exit");

        System.out.print("input numbre of choice : ");
        choice = sc.nextInt();

        int x,z;
        double y = Math.sqrt(3)/4;
        switch (choice) {
            case 1 : System.out.print("Hight of Triangle = ");
            x = sc.nextInt();
            System.out.println("Area of Triangle = "+y*Math.pow(x,2));
            break;

            case 2 : System.out.print("Side of Square = ");
            z=sc.nextInt();
            System.out.println("Area of Square = "+z*z);
            break;
        
            default: System.out.print("สิ้นสุดโปรแกรม");
            
        }
    }
}
