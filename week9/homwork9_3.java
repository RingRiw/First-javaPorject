package week9;
import java.util.*;
public class homwork9_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[]arr = new int[5];

        for(int i=0; i<arr.length; i++){
            System.out.print("Array Index "+i+" : ");
             arr[i] = sc.nextInt();
        }

        int min = arr[0];
        int max = arr[0];

        for(int i=0; i<arr.length; i++){
            if(arr[i]<min){
                min = arr[i];
            }
            if(arr[i]>max){
                max = arr[i];
            }
        }
        System.out.println("Min : "+min+"\nMax : "+max);

        System.out.print("Search : ");
        int s = sc.nextInt();
        
        int searchArray(arr,s;)

        static void searchArray(int[]arr,int s){
            for( int i=0; i<arr.length; i++){
                if(s==arr[i])
                System.out.println("Find "+s+" at : "+i);
            }
        }

    }
}
