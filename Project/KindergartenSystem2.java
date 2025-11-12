package Project;
import java.util.*;
import java.io.*;

public class KindergartenSystem2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n        Jooma School System     ");
        
/* Login */

        int tl = 1;
        while (tl<4) {
            
            System.out.print("\nPassword : ");
            String password_in = sc.nextLine();
            
            if (password_in.equals("007")){
                System.out.println("\nWelcome to Jooma School System :)\n");
                break;
            }
            else{
                System.out.println("\nTry again >:( "+tl+"!");
                tl++;
                if(tl==4){
                    System.out.println("\nTry again in 1 min.");
                    return;
                }
            }
            
        }
/* เมนูหลัก */
        while (true){

            System.out.println("1. Add student information");
            System.out.println("2. Show student information");
            System.out.println("3. Search students information");
            System.out.println("4. Delete student information");
            System.out.println("0. exit");
            System.out.print("Select Menu: ");
            
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice < 0 || choice > 4) {
                System.out.println("\n** Only 0-4! **\n");
                continue;
            }

            switch (choice) {

/* เพิ่มข้อมูลนักเรียน */

                case 1: 

                    System.out.println("\n----- Add Student -----\n");
                    
                    int id = 1;
                    File allfile = new File("Student.txt");

                    if (allfile.exists()) {
                        try (BufferedReader br = new BufferedReader(new FileReader(allfile))) {
                            while (br.readLine() != null) {
                                id++;
                            }
                        }
                    }else {
                        allfile.createNewFile();
                        System.out.println("Created file: Student.txt");
                    }


                    String studentId = String.format("%04d", id);
                    System.out.println("Generated ID: " + studentId); 

                    System.out.print("Name : ");
                    String name = sc.nextLine();        

                    System.out.print("Age : ");
                    int age = sc.nextInt();            
                    sc.nextLine();

                    int y;
                    while (true) {
                        System.out.print("Year : ");
                        y = sc.nextInt();               
                        sc.nextLine();

                        if (y >= 1 && y <= 3)break;
                        System.out.println("** Please enter Year only 1-3. **\n");
                    }
                    
                    int room;
                    while (true) {
                        System.out.print("Classroom number (1-3): ");
                        room = sc.nextInt();
                        sc.nextLine();
                
                        if (room >= 1 && room <= 3)break;
                        System.out.println("** Classroom Only 1-3 **.\n"); 
                    }
                
// นำค่าที่รับมาทำเป็นตัวแปร เพื่อสร้างไฟล์

                    String filename = "K" + y + "_" + room + ".txt";
                    File classFile = new File(filename);
                
                    if (!classFile.exists()) {
                        classFile.createNewFile();
                        System.out.println("Created file: " + filename);
                    }
                
                    String studentData = "ID : " + studentId +
                                         " Name : " + name +
                                         " Age : " + age +
                                         " Year:K" + y +
                                         "_" + room;
                
// บันทึกลงไฟล์ห้อง

                    try (FileWriter fw = new FileWriter(classFile, true);
                         PrintWriter out = new PrintWriter(fw)) {
                        out.println(studentData);
                    }
                
// บันทึกลงไฟล์รวมนักเรียนทั้งหมด (Student.txt)

                    try (FileWriter fwAll = new FileWriter(allfile, true);
                         PrintWriter outAll = new PrintWriter(fwAll)) {
                        outAll.println(studentData);
                    }
                
                    System.out.println("Student added to " + filename + " and Student.txt successfully!\n");
                    break;
            
/* แสดงข้อมูลนักเรียน */

                case 2: 

                    System.out.println("\n----- Students information -----\n");

                    while (true) {
                    System.out.println("1. All Student information");
                    System.out.println("2. All Student information by Year");
                    System.out.println("3. All Student information by Room");
                    System.out.println("0. Back to Main Menu");
                    System.out.print("Select Submenu: ");

                    choice = sc.nextInt();
                    sc.nextLine();
                    
                    if(choice==0)break;
                    
                    if (choice < 0 && choice > 3) {
                        System.out.println("\n** Only 1-4! **\n");
                        continue;
                    }
                    
                    switch (choice) {

     
    /* แสดงข้อมูลนักเรียนทั้งหมด */

                        case 1: 
                            System.out.println("\n----- All Student information -----\n");
                            try (BufferedReader br = new BufferedReader(new FileReader("Student.txt"))) {
                            String line;
                            boolean empty1 = true;

                            while ((line = br.readLine()) != null)
                            {
                                System.out.println(line);
                                empty1 = false;
                            }

                            if (empty1) System.out.println("No student data found.\n");
                        }
                         catch (FileNotFoundException e) {System.out.println("No student data file found.\n");}
                            System.out.println();
                            break;

    /* แสดงข้อมูลนักเรียนทั้งหมดในชั้นปี */

                        case 2:

                            System.out.println("\n----- All Student information by Year -----");

    // รับค่าปีที่ต้องการหา

                            int sy1;
                            while (true) {
                            System.out.print("\nYear (1-3) : K");
                            sy1 = sc.nextInt();
                            sc.nextLine();
                            if (sy1 >= 1 && sy1 <= 3)
                                break;
                            }
                            
                            boolean foundYear = false;
                             
                            System.out.println("\nAll Student information Year "+sy1+"\n");

    // แล้วกำหนดตัวแปรให้รันครบจำนวนห้องที่มี

                            for (int r = 1; r <= 3; r++) {
                                String fileName = "K" + sy1 + "_" + r + ".txt"; //แล้วนำค่าทั้งหมดมาเป็นตัวแปรที่มีชื่อเหมือนไฟล์ข้อมูล
                                File file = new File(fileName);
                
    // ข้ามถ้าไม่พบไฟล์

                                if (!file.exists()) continue;

                                try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                                    String line;
                                    System.out.println("--> " + fileName+"\n");
                                    while ((line = br.readLine()) != null) {
                                        System.out.println(line);
                                        foundYear = true;
                                    }
                                } catch (IOException e) {
                                    System.out.println("Error reading " + fileName);
                                }
                            }
                
                            if (!foundYear) System.out.println("No data found for Year K" + sy1 + "\n");
                            break;
                
    /* แสดงข้อมูลนักเรียนทั้งหมดในห้อง */

                        case 3:
                            System.out.println("\n----- All Student information by Room -----");
                            
                            int sy2;
                            while (true) {
                                System.out.print("\nYear (1-3) : K ");
                                sy2 = sc.nextInt();
                                if (sy2 >= 1 && sy2 <= 3) break;
                                System.out.println("\n** Plase input year 1-3! **");   
                            }
                            
                            int sr;
                            while (true) {
                                System.out.print("Room (1-3) : ");
                                sr = sc.nextInt();
                                sc.nextLine();
                                if (sr >= 1 && sr <= 3) break;
                                System.out.println("\n** Plase input room 1-3! **\n"); 
                            }
                                
                            sc.nextLine();
                
    //รับค่า ปี + ห้อง มาทำตัวแปรที่มีค่าเป็นชื่อไฟล์

                            String fileName = "K" + sy2 + "_" + sr + ".txt";
                            File file = new File(fileName);
                
                            if (!file.exists()) {
                                System.out.println("\nNo student file for " +fileName);
                                break;
                            }
                
                            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                                String line;
                                boolean empty3 = true;
                                System.out.println("Students in " + fileName);
                                while ((line = br.readLine()) != null) {
                                    System.out.println(line);
                                    empty3 = false;
                                }
                                if (empty3) System.out.println("No student data in this class.\n");
                            } catch (IOException e) {
                                System.out.println("Error reading file " + fileName);
                            }
                            break;
                    } 
                    break;
                }
                break;

/* หาข้อมูลนักเรียน */                    

                case 3: 
                    System.out.println("\n----- Search Student Information -----\n");

                    while (true) {
                        System.out.println("1. Search by ID");
                        System.out.println("2. Search by Name");
                        System.out.println("0. Back to Main Menu");
                        System.out.print("Select Submenu: ");

                        choice = sc.nextInt();
                        sc.nextLine();

                        if(choice==0)break;

                        if (choice < 0 || choice > 3) {
                        System.out.println("\nOnly 1-3!\n");
                        continue;
                    }

    /* หาด้วยไอดี */

                    switch (choice) {
                        case 1:
                            System.out.println("\n----- Search by ID -----");
                            System.out.print("\nEnter Student ID (e.g. 0001): ");
                            String sid = sc.nextLine();

                            boolean foundId = false;
                            try (BufferedReader br = new BufferedReader(new FileReader("Student.txt"))) {
                            String line;
                            while ((line = br.readLine()) != null) {
                            if (line.contains("ID : " + sid)) {
                            System.out.println("\n" + line+"\n");
                            foundId = true;
                                }
                            }
                            if (!foundId) System.out.println("\nID not found.\n");
                            } 
                            catch (FileNotFoundException e) {
                            System.out.println("No student data file found.\n");
                            }
                            break;
                          
    /* หาด้วยชื่อ */                       

                        case 2:
                            System.out.println("\n----- Search by Name -----");
                            System.out.print("\nEnter Student Name : ");
                            String sname = sc.nextLine();

                            boolean foundname = false;
                            try (BufferedReader br = new BufferedReader(new FileReader("Student.txt"))) {
                            String line;

                            while ((line = br.readLine()) != null) {
                            if (line.toLowerCase().contains(sname.toLowerCase())) {
                            System.out.println("\n" + line+"\n");
                            foundId = true;
                                }
                            }
                            if (!foundname) System.out.println("\nName not found.\n");
                            } 
                            catch (FileNotFoundException e) {
                            System.out.println("No student data file found.\n");
                            }
                            break;
                    }
                }
                   
/* ลบข้อมูล */

                case 4: 
                    System.out.println("\n----- Delets Student Tnformation -----");

                    System.out.print("\nEnter Student ID to delete (0001-9999) : ");
                    String delid = sc.nextLine();

                    boolean delete = false;

                break;

                case 0: 
                    System.out.println("\nExiting Jooma School System\nBye ;p");
                    return;
            
                default: System.out.println("Pla");
                    return;
            }
        }
    }
}



