import java.util.Scanner;
public class Financecalculation {
    public static void main(String[]agrs){
        Scanner sc = new Scanner(System.in);

        double carprice = 0.0;          // ราคารถ
        double downpayment = 0.0;       // เงินดาวน์
        double intrate_rate = 0.0;      // อัตราดอกเบี้ย
        double totalpayment = 0.0;      // ยอดรวมทั้งหมด 
        double monthlypayment = 0.0;    // ค่างวดต่อเดือน
        int paymonth = 0;               // จำนวนเดือนผ่อน
        double finance = 0.0;           // ไฟแนนซ์
        double totalmonth = 0.0;        // ยอดต่อเดือนรวมดอก
        double totalinterest = 0.0;     // ดอกทั้งหมด

        //รับค่า ราคา ดาว เดือน ดอกเบี้ย

        System.out.print("Input Car price : ");
        carprice = sc.nextDouble();

        System.out.print("Input Down payment : ");
        downpayment = sc.nextDouble();

        System.out.print("Input interest rate : ");
        intrate_rate = sc.nextDouble();
        
        System.out.print("Input Pay month : ");
        paymonth = sc.nextInt();

        //คำนวณ

        finance = carprice-(carprice*(downpayment/100));
        monthlypayment = finance/paymonth;
        totalmonth = monthlypayment+(monthlypayment*(intrate_rate/100));
        totalpayment = totalmonth*paymonth;
        totalinterest = totalpayment-finance;

        System.out.println("Price of car : "+carprice+" Bath");

        System.out.println("Period of payment : "+paymonth+" Months");

        System.out.println("Interest rate : "+intrate_rate+" %");

        System.out.println("Total Interest : "+totalinterest+" Bath");

        System.out.println("Payment permonth : "+totalmonth+" Bath");
    }
}
 