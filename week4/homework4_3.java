import java.util.Scanner;

public class homework4_3 {
    public static void main(String[]args){
       
        Scanner sc = new Scanner(System.in);

        double Month = 0 , TotalIncome = 0 ;

        for (int i = 1; i<= 12; i++)
        {
            System.out.print("Month "+i+" : ");
            Month = sc.nextDouble();
            TotalIncome=TotalIncome+Month;
        }
        double tax;
        if(TotalIncome <=100000)
        {tax = (TotalIncome*0.05);}
        else if(TotalIncome >100000 && TotalIncome <=500000)
        {tax = (TotalIncome*0.1);}
        else if(TotalIncome >500000 && TotalIncome <=1000000)
        {tax = (TotalIncome*0.2);}
        else if(TotalIncome >1000000 && TotalIncome <4000000)
        {tax = (TotalIncome*0.3);}
        else{tax = (TotalIncome*0.37);}

        System.out.println("So, your total income = "+ TotalIncome +"Baht");
        System.out.println("Your tax = "+ tax +" Baht");
    }
}
