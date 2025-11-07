package Project;
import java.util.*;
import java.io.*;

public class KindergartenSystem2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int i = 1;
        while (i<4) {
            
            System.out.print("Password : ");
            String password_in = sc.nextLine();
            
            if (password_in.equals("007")){
                System.out.println("Welcome to Kindergarten System :)\n");
                break;
            }
            else{
                System.out.println("Try again >:( "+i+"!");
                i++;
                if(i==4){
                    System.out.println("Try again in 1 min.");
                    return;
                }
            }
            
        }

        while (true){

            System.out.println("1. Add student information");
            System.out.println("2. Show all student information");
            System.out.println("3. Search for students by name");
            System.out.println("4. Delete student information");
            System.out.println("0. exit");
            System.out.print("Select Menu: ");
            
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Name : ");
                    String name = sc.nextLine();

                    System.out.print("Age : ");
                    String age = sc.nextLine();

                    System.out.print("Classroom : ");
                    String classroom = sc.nextLine();

                    try (FileWriter fw = new FileWriter("Student.txt", true);
                        PrintWriter out = new PrintWriter(fw)){
                        out.println(name + " " + age + " " + classroom);
                    }
                
                    System.out.println(" Completed !! ");
                    break;


                case 2:
                     System.out.println("\n--- All Students ---");

                    try (BufferedReader br = new BufferedReader(new FileReader("Student.txt"))) {
                        String line;
                        boolean empty = true;

                        while ((line = br.readLine()) != null)
                        {
                            System.out.println(line);
                            empty = false;
                        }

                        if (empty){
                            System.out.println("No student data found.\n");
                        }
                    }

                        catch (FileNotFoundException e){
                            System.out.println("No student data file found.\n");
                    }
                    System.out.println();
                    break;
            
                default: System.out.println("eiei");
                    break;
            }
        }
    }
}
