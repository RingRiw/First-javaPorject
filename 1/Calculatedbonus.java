import java.util.Scanner;
public class Calculatedbonus{
    public static void main(String[]agrs){
        Scanner sc = new Scanner(System.in);
        double Yrs=0.0, salary=0.0, bonus=0.0;
        
        System.out.print("Input Salary : ");
        salary=sc.nextDouble();
        
        System.out.print("Input WorkYrs : ");
        Yrs=sc.nextDouble();

        //....................................
        
        if(Yrs>=16){
            bonus+=salary*0.4;
        }
        else if((Yrs>=6)&&(Yrs<=15)){
            bonus+=salary*0.2;
        }
        else if((Yrs>=1)&&(Yrs<=5)){
            bonus+=salary*0.1;
        }

        System.out.print("Your Bonus : "+bonus);
    }
}