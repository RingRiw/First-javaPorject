package week9;
import java.util.*;
public class homework9_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of emplayees : ");
        int n = sc.nextInt();
        sc.nextLine();


        int[] id = new int[n];
        String[] name = new String[n];
        double[] sales = new double[n];
        double[] cost = new double[n];
        double[] profit = new double[n];
        double[] commission = new double[n];


        for(int i = 0; i<n; i++){
            
            System.out.println("\nEnter data for employee "+(i+1));
            
            System.out.print("Employee ID : ");
            id[i] = sc.nextInt();
            sc.nextLine();

            System.out.print("Employee Name : ");
            name[i] = sc.nextLine();

            System.out.print("Sales : ");
            sales[i] = sc.nextDouble();

            System.out.print("Cost : ");
            cost[i] = sc.nextDouble();


            profit[i] = sales[i] - cost[i];
            if(sales[i] <= 5000)
                commission[i] = profit[i]*0.10;
            else commission[i] = profit[i]*0.05;

        }

        System.out.printf("\n%8s %10s %10s %10s %10s %12s\n","Number","Name","Sales","Value","Profit","Commission");

        for (int i = 0; i<n; i++){
            System.out.printf("\n%8d %10s %10.2f %10.2f %10.2f %12.2f\n",id[i],name[i],sales[i],cost[i],profit[i],commission[i]);
        }
        sc.close();
    }
}
