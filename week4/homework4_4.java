import java.util.Scanner;
public class homework4_4 {
    public static void main(String[]args){

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++)
        {System.out.print("Please input number of month (1-12) : ");
        int month = sc.nextInt();
    
        String MonthName;
        switch (month){
            case 1 : MonthName = "January"; break;
            case 2 : MonthName = "February"; break;
            case 3 : MonthName = "March"; break;
            case 4 : MonthName = "April"; break;
            case 5 : MonthName = "May"; break;
            case 6 : MonthName = "June"; break;
            case 7 : MonthName = "July"; break;
            case 8 : MonthName = "August"; break;
            case 9 : MonthName = "September"; break;
            case 10 : MonthName = "October"; break; 
            case 11 : MonthName = "November"; break;
            case 12 : MonthName = "December"; break;
            default : MonthName = "Not found that month.";
        }
        System.out.println("The nuber of monthb = "+ month +" is "+MonthName+"\n");
    }
        }
}
