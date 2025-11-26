import java.util.*;
import javax.print.attribute.SetOfIntegerSyntax;
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

            System.out.println("\n----- Main Menu -----\n");
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
                    System.out.println("ID: " + studentId); 

                    System.out.print("Name : ");
                    String name = sc.nextLine();        

                    System.out.print("Age : ");
                    int age = sc.nextInt();            
                    sc.nextLine();

                    int y;
                    while (true) {
                        System.out.print("Year (1-3): ");
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
                        System.out.println("\n** Only 0-3! **\n");
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
                                System.out.println("\nStudents in " + fileName);

                                System.out.printf("%-5s %-10s %-4s %-5s %-5s\n\n", "ID", "name", "age", "Year", "Room");

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
                    System.out.println("\n----- Edit student information -----\n");

                    System.out.print("Enter Student ID (0001-9999) : ");
                    String edid =sc.nextLine();

                    File editFile = new File("Student.txt");
                    File tempedit = new File("tempedit.txt");

                            
                    boolean edit = false;
                    String edids = "";
                    String edname = "";
                    String edage = "";
                    String edy = "";
                    String edr = "";

                    String newname = "";
                    String newage = "";
                    String newy  = "";
                    String newr = "";

                    try (BufferedReader br = new BufferedReader(new FileReader(editFile));
                    PrintWriter pw = new PrintWriter(new FileWriter(tempedit))){

                        String line;
                        while ((line = br.readLine())!=null) {
                            String []arr = line.split(" ");
                            edids = arr[0];
                            edname = arr[1];
                            edage = arr[2];
                            edy = arr[3];
                            edr = arr[4];

                            if(edid.equals(edids)){
                                System.out.print("Name : ");
                                newname = sc.nextLine();
                                if(newname.isEmpty()){newname = edname;}

                                System.out.print("Age : ");
                                newage = sc.nextLine();
                                if(newage.isEmpty()){newage = edage;}

                                System.out.print("Year : ");
                                newy = sc.nextLine();
                                if(newy.isEmpty()){newy = edy;}

                                System.out.print("Room : ");
                                newr =sc.nextLine();
                                if(newr.isEmpty()){newr = edr;}
                            }
                                
                            System.out.print("Confirm edit student? Y/N : ");
                            String y_n = sc.nextLine();

                            while(true){
                                String newclassroom = "K"+newy+"_"+newr+".txt";
                                String oldclassroom = "K"+edy+"_"+edr+".txt";

                                if (y_n.equalsIgnoreCase("Y")) {
                                    edit = true;
                                    line = edids+" "+newname+" "+newage+" "+newy+" "+newr;
                                    editFile.delete();
                                    tempedit.renameTo(editFile);
                                    break;
                                }
                                else if(y_n.equalsIgnoreCase("N")){
                                System.out.println("Canceled. Edit student information");
                                break;
                                }
                                else{
                                System.out.println("Only Y or N !");
                                }
                                }
                                }
                                pw.println(line);

                               
                            
                        }
                                
                            
            
                            catch (Exception e) {
                        
                            }
                            if(editFile.delete()) {
    if(tempedit.renameTo(editFile)) {
        System.out.println("File updated successfully!");
    } else {
        System.out.println("Failed to rename temp file!");
    }
} else {
    System.out.println("Failed to delete original file!");
}

                            
        
/*----------------------------------------------------------------------------------------------------------------------------------
                                                            Deletes
------------------------------------------------------------------------------------------------------------------------------------*/

                case 5: 
                    System.out.println("\n----- Delete Student Tnformation -----");

                    System.out.print("\nEnter Student ID to delete (0001-9999) : ");
                    String delid = sc.nextLine();

                    File origFile = new File("Student.txt");
                    File tempFile = new File("temp.txt");

                    boolean found = false;
                    String dely = "";
                    String delr = "";
                    String dleLine = "";

                    try (BufferedReader br = new BufferedReader(new FileReader(origFile))){
                        String line;

                        while ((line = br.readLine()) !=null) {
                            if (line.startsWith(delid + " ")) {
                                found = true;
                                dleLine = line;
                                
                                String[] arr = line.split(" ");
                                dely = arr[3];
                                delr = arr[4];
                            }
                        }  
                    }
                    if(found){ 
                        System.out.print("Confirm to delete student? Y/N : ");
                        String y_n = sc.nextLine();

                       if(y_n.equalsIgnoreCase("Y"))
                       {
                        try(BufferedReader br = new BufferedReader(new FileReader(origFile));
                        PrintWriter pw = new PrintWriter(new FileWriter(tempFile))){

                            String line;
                            while ((line = br.readLine()) !=null) {
                                if(line.equals(dleLine)) continue;
                                pw.println(line);
                            }
                        }
                        origFile.delete();
                        tempFile.renameTo(origFile);

                        String classFilename = "K"+dely+"_"+delr+".txt";
                        File classFile = new File(classFilename);
                        File tempClass = new File("tempClass.txt");

                        try(BufferedReader br = new BufferedReader(new FileReader(classFile));
                        PrintWriter pw = new PrintWriter(new FileWriter(tempClass))){

                            String line;
                            while ((line = br.readLine()) !=null) {
                                if(line.equals(dleLine)) continue;
                                pw.println(line);
                            }
                        }
                        classFile.delete();
                        tempClass.renameTo(classFile);
                        System.out.println("Delete successfully!\\n");
                        }
                       else if(y_n.equalsIgnoreCase("N")){
                        System.out.println("Canceled ");
                        tempFile.delete();
                        break;
                        }
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

                break;

                default: System.out.println("Pla");
                    return;
            }
        }
    }
}


//sss