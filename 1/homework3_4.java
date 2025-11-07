import java.util.Scanner;
public class homework3_4 {
    public static void main(String[]agrs){
        Scanner sc = new Scanner(System.in);

        int a=5, b=3, c=2, d=8;
        double one, two, three;

        one=(a+b*2-(d-c)%b+a);
        two=((b+c+d)%5);
        three=(b+(c+d/c)-a);

        System.out.println("a = 5, b = 3, c = 2, d = 8");

        System.out.println("(a+b*2-(d-c)%b+a) = "+one);

        System.out.println("((b+c+d)%5) = "+two);

        System.out.println("(b+(c+d/c)-a) = "+three);

        // แสดงวิธีทำแล้วแสดงผลลัพธ์ โดยกำหนดค่าให้ a=5, b=3, c=2, d=8

        /* จากโจทย์ (a+b*2-(d-c)%b+a)
            1. b * 2 = 3 * 2 = 6
            2. (d - c) = 8 - 2 = 6
            3. (d - c) % b = 6 % 3 = 0 (การหารเอาเศษจากการหาร 6 ด้วย 3)
            4. a + b * 2 = 5 + 6 = 11
            5. a + b * 2 - (d - c) % b = 11 - 0 = 11
            6. 11 + a = 11 + 5 = 16 
        */ 

        /* จากโจทย์ ((b+c+d)%5)
            1. (b + c + d) = 3 + 2 + 8 = 13=
            2. 13 % 5 = 13 หาร 5 เหลือเศษ 3
        */

        /* จากโจทย์(b+(c+d/c)-a)
            1. d / c = 8 / 2 = 4 (การหารจำนวนเต็ม)
            2. c + d / c = 2 + 4 = 6
            3. b + (c + d / c) = 3 + 6 = 9
            4. 9 - a = 9 - 5 = 4
         */
    }
}
