import java.util.*;
import java.io.*;

public class KindergartenSystem2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n        Jooma School System     ");
        
/*----------------------------------------------------------------------------------------------------------------------------------
                                                         Login 
------------------------------------------------------------------------------------------------------------------------------------*/

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
        
/*----------------------------------------------------------------------------------------------------------------------------------
                                                        Main Menu
------------------------------------------------------------------------------------------------------------------------------------*/

        while (true){

            System.out.println("\n----- Main Menu -----");
            System.out.println("1. Add student information");
            System.out.println("2. Show student information");
            System.out.println("3. Search students information");
            System.out.println("4. Edit student information");
            System.out.println("5. Delete student information");
            System.out.println("0. exit");
            System.out.print("Select Menu: ");
            
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice < 0 || choice > 5) {
                System.out.println("\n** Only 0-5! **\n");
                continue;
            }

            switch (choice) {
        
/*----------------------------------------------------------------------------------------------------------------------------------
                                                    Add information 
------------------------------------------------------------------------------------------------------------------------------------*/

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
                

                    while (true) {
                        System.out.print("\nConfirm add student? (Y/N) :");
                        String y_n = sc.nextLine().trim();
                        
                        if (y_n.equalsIgnoreCase("Y")) {

 // นำค่าที่รับมาทำเป็นตัวแปร เพื่อสร้างไฟล์

                            String filename = "K" + y + "_" + room + ".txt";
                            File classFile = new File(filename);
                
                            if (!classFile.exists()) {
                            classFile.createNewFile();
                            System.out.println("Created file: " + filename);
                    }
                
                            String studentData = studentId +" " + name +" " + age +" " + y +" " + room;
                
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
                        }
                        else if (y_n.equalsIgnoreCase("N")) {
                            System.out.println("\nCanceled. Student not added. \n");
                            break;
                        }
                        else{
                            System.out.println("Only Y or N");
                        }
                    }
                    break;

        
/*----------------------------------------------------------------------------------------------------------------------------------
                                                    Show information 
------------------------------------------------------------------------------------------------------------------------------------*/

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
        
/*----------------------------------------------------------------------------------------------------------------------------------
                                                    All information 
------------------------------------------------------------------------------------------------------------------------------------*/

                        case 1: 
                            System.out.println("\n----- All Student information -----\n");
                            try (BufferedReader br = new BufferedReader(new FileReader("Student.txt"))) {
                                
                            System.out.printf("%-5s %-10s %-4s %-5s %-5s\n", "ID", "name", "age", "Year", "Room");

                            String line;
                            boolean empty1 = true;

                            while ((line = br.readLine()) != null)
                            {
                            String []arr = line.split(" ");
                            String said = arr[0];
                            String saname = arr[1];
                            String saage = arr[2];
                            String say = arr[3];
                            String sar = arr[4];

                            System.out.printf("%-5s %-10s %-4s %-5s %-5s\n", said, saname, saage, say, sar);
                                empty1 = false;
                            }

                            if (empty1) System.out.println("No student data found.\n");
                        }
                         catch (FileNotFoundException e) {System.out.println("No student data file found.\n");}
                            System.out.println();
                            break;
        
/*----------------------------------------------------------------------------------------------------------------------------------
                                                    Year information 
------------------------------------------------------------------------------------------------------------------------------------*/

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

                                foundYear = true;

                                try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                                    String line;
                                    System.out.println("--> " + fileName+"\n");

                                    System.out.printf("%-5s %-10s %-4s %-5s %-5s\n", "ID", "name", "age", "Year", "Room");

                                    while ((line = br.readLine()) != null) {
                                        String []arr = line.split(" ");
                                        String syid = arr[0];
                                        String syname = arr[1];
                                        String syage = arr[2];
                                        String syy = arr[3];
                                        String syr = arr[4];

                                        System.out.printf("%-5s %-10s %-4s %-5s %-5s\n", syid, syname, syage, syy, syr);    
                                    }
                                    System.out.println();

                                } catch (IOException e) {
                                    System.out.println("Error reading " + fileName);
                                }
                            }
                
                            if (!foundYear) System.out.println("No data found for Year K" + sy1 + "\n");
                            break;
            
/*----------------------------------------------------------------------------------------------------------------------------------
                                                    Room information 
------------------------------------------------------------------------------------------------------------------------------------*/

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

                                System.out.printf("%-5s %-10s %-4s %-5s %-5s\n", "ID", "name", "age", "Year", "Room");

                                while ((line = br.readLine()) != null) {
                                    String []arr = line.split(" ");
                                    String srid = arr[0];
                                    String srname = arr[1];
                                    String srage = arr[2];
                                    String sry = arr[3];
                                    String srr = arr[4];

                                    System.out.printf("%-5s %-10s %-4s %-5s %-5s\n", srid, srname, srage, sry, srr);
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
        
/*----------------------------------------------------------------------------------------------------------------------------------
                                                        Search 
------------------------------------------------------------------------------------------------------------------------------------*/

                case 3: 
                     System.out.println("\n----- Search by ID -----");
                     System.out.print("\nEnter Student ID (e.g. 0001): ");
                     String sid = sc.nextLine();

                    boolean foundId = false;
                    try (BufferedReader br = new BufferedReader(new FileReader("Student.txt"))) {
                    String line;

                    System.out.printf("\n%-5s %-10s %-4s %-5s %-5s\n", "ID", "name", "age", "Year", "Room");

                    while ((line = br.readLine()) != null) {
                    if (line.startsWith(sid + " ")) {
                        String []arr = line.split(" ");
                        String siid = arr[0];
                        String siname = arr[1];
                        String siage = arr[2];
                        String siy = arr[3];
                        String sir = arr[4];

                        System.out.printf("%-5s %-10s %-4s %-5s %-5s\n\n", siid, siname, siage, siy, sir);
                        foundId = true;
                                }
                            }
                            if (!foundId) System.out.println("\nID not found.\n");
                            } 
                            catch (FileNotFoundException e) {
                            System.out.println("No student data file found.\n");
                            }
                            break;
        
/*----------------------------------------------------------------------------------------------------------------------------------
                                                            Edit 
------------------------------------------------------------------------------------------------------------------------------------*/

                case 4:
                    System.out.println("\n----- Edit student information -----");

                    System.out.print("Enter Student ID (0001-9999) : ");
                    String edid =sc.nextLine();

                    File editFile = new File("Student.txt");
                    File tempedit = new File("tempedit.txt");

                    boolean edit = false;

                    try (BufferedReader br = new BufferedReader(new FileReader(editFile));
                    PrintWriter pw = new PrintWriter(new FileWriter(tempedit))){

                        String line;
                        while ((line = br.readLine())!=null) {
                            String []arr = line.split(" ");
                            String edids = arr[0];
                            String edname = arr[1];
                            String edage = arr[2];
                            String edy = arr[3];
                            String edr = arr[4];

                            if(edid.equals(edids)){
                                System.out.println("Name : ");
                                String nameed = sc.nextLine();
                                if(nameed.isEmpty()){nameed = edname;}

                                System.out.println("Age : ");
                                String ageed = sc.nextLine();
                                if(ageed.isEmpty()){ageed=edage;}
                                
                                System.out.println("Year : ");
                                String yed = sc.nextLine();

                                if (yed.equals("1")||yed.equals("2")||yed.equals("3")||yed.isEmpty()){
                                    if(yed.isEmpty()){yed=edy;}
                                }
                                
                                else {System.out.println("** Please enter Year only 1-3. **\n");}
                                
                                
                                System.out.println("Classroom number (1-3): ");
                                String red = sc.nextLine();

                                if (red.equals("1")||red.equals("2")||red.equals("3")||red.isEmpty()){
                                    if(red.isEmpty()){red=edr;}
                                }
                                
                                else {System.out.println("** Please enter Classroom only 1-3. **\n");}
                                
                            line = edids+" "+nameed+" "+ageed+" "+yed+" "+red;
                            }
                            pw.println(line);
                        }
                        
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
        
/*----------------------------------------------------------------------------------------------------------------------------------
                                                            Delets
------------------------------------------------------------------------------------------------------------------------------------*/

                case 5: 
                    System.out.println("\n----- Delets Student Tnformation -----");

                    System.out.print("\nEnter Student ID to delete (0001-9999) : ");
                    String delid = sc.nextLine();

                    File origFile = new File("Student.txt");
                    File tempFile = new File("temp.txt");

                    boolean delete = false;

                    try (BufferedReader br = new BufferedReader(new FileReader(origFile));
                    PrintWriter pw = new PrintWriter(new FileWriter(tempFile))){

                        String line;
                        while ((line = br.readLine()) !=null) {
                            if (line.startsWith(delid + " ")) {
                                delete = true;
                                continue; 
                            }
                            pw.println(line);
                        }

                       
                    }
                    if(delete){ 
                        System.out.print("Confirm delets student? Y/N : ");
                        String y_n = sc.nextLine();

                       if(y_n.equalsIgnoreCase("Y"))
                       {
                        origFile.delete();
                        tempFile.renameTo(origFile);
                       }
                       else if(y_n.equalsIgnoreCase("N"))break;

                       else
                       {
                        System.out.println("Only Y or N !");
                        continue;
                       }
                    }
                    else{
                        tempFile.delete();
                        System.out.println("Student ID not found.\n");
                    }

                    for(int dely=1; dely<=3; dely++){
                        for(int delr =1; delr<=3; delr++){
                            String classFileName = "K" + dely + "_" + delr + ".txt";
                            File classFiledel = new File(classFileName);
                            if(!classFiledel.exists()) continue;

                            File tempClass = new File("tempClass.txt");
                            boolean remove = false;

                            try (BufferedReader br = new BufferedReader(new FileReader(classFiledel));
                                PrintWriter pw = new PrintWriter(new FileWriter(tempClass))){

                                String line;
                                while ((line = br.readLine())!=null) {
                                    if(line.contains("ID : "+delid)){
                                        remove = true;
                                        continue;
                                    }
                                    pw.println(line);
                                }
                            }
                            if (remove) {
                                classFiledel.delete();
                                tempClass.renameTo(classFiledel);
                                System.out.println("Student ID "+delid+" deleted complete!");
                            }
                            else tempClass.delete();
                        }
                    }
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


//sss