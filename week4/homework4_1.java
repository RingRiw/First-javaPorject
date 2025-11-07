import java.util.Scanner;
public class homework4_1 {
    public static void main(String[]agrs){
        Scanner sc = new Scanner(System.in);

        double price , depreciation , depreciationPercent , NetCost;

        System.out.print("Input product price : ");
        price = sc.nextDouble();
        System.out.print("Input depreciation(%) : ");
        depreciationPercent = sc.nextDouble();

        System.out.println("\nresult");
        System.out.printf("%-5s %-15s %-15s %-15s\n", "Year", "product_price", "depreciation", "net_cost");

        for(int year = 1; year <= 5; year++)
        {
            depreciation = price * (depreciationPercent / 100);
            NetCost = price - depreciation;

            System.out.printf("%-5d %-15.2f %-15.2f %-15.2f\n", year, price, depreciation, NetCost);

            price = NetCost;
        }
    }
}
