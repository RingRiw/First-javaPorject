import java.util.Scanner;
public class homework4_2 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int year = 0;
        double Salary = 0, bonus = 0, totalBonus = 0;

        for (int i = 1; i <= 5; i++)
        {
            System.out.println("Input Information of employee " + i);
            System.out.print("Salary : ");
            Salary = sc.nextDouble();
            System.out.print("Year of work : ");
            year = sc.nextInt();

            if(year >= 1 && year <= 5){ bonus = Salary * 0.10; }
            else if(year >= 6 && year <= 15){ bonus = Salary * 0.20; }
            else if(year >= 16){ bonus = Salary * 0.30; }

            System.out.printf("Employee " + i + "\nbonus : " + bonus);
            totalBonus += bonus;
            System.out.printf("\n Total bonus for all employees : "+totalBonus+"\n");
            
        }
        
    }
}