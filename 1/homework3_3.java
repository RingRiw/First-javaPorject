import java.util.Scanner;
public class homework3_3 {
    public static void main(String[]agrs){
        Scanner sc = new Scanner(System.in);

        int a=5, b=3, c=2, d=8;

        System.out.print(((a>b)&&(a<d))&&((c>d)||(b<d)));

        // && = (AND) ใช้ตรวจสอบว่าเงื่อนไขทั้งหมดเป็นจริงหรือไม่
        // || = (OR) ใช้ตรวจสอบว่าเงื่อนไขใดเงื่อนไขหนึ่งเป็นจริงหรือไม่
        // กรณีนี้ a>b = true, a<d = true, c>d = false,
        // ดังนั้น ((a>b)&&(a<d)&&c>d) = false
        // แต่ b<b = true
        /*สรุป ((a>b)&&(a<d)&&c>d)||b<d = true เพราะ b<d เป็นจริง
          โดย OR จะเป็น จริง ถ้าเงื่อนไขใดเงื่อนไขหนึ่งเป็นจริง*/

    }
    
}
