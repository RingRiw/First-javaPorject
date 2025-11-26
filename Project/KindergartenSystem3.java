import java.io.*;
import java.util.*;

public class KindergartenSystem3 {

    public static void main(String[] args) {
        new KindergartenSystem3().run();
    }

    Scanner sc = new Scanner(System.in);

    void run() {
        System.out.println("\n        Jooma School System     ");

        if (!login()) return;

        while (true) {
            System.out.println("\n----- Main Menu -----\n");
            System.out.println("1. Add student information");
            System.out.println("2. Show student information");
            System.out.println("3. Search students information");
            System.out.println("4. Edit student information");
            System.out.println("5. Delete student information");
            System.out.println("0. Exit");
            System.out.print("Select Menu: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("\nPlease input a number 0-5!");
                continue;
            }

            switch (choice) {
                case 1: handleAdd(); break;
                case 2: handleShow(); break;
                case 3: handleSearch(); break;
                case 4: handleEdit(); break;
                case 5: handleDelete(); break;
                case 0: System.out.println("Exiting..."); return;
                default: System.out.println("Please input 0-5!");
            }
        }
    }

    boolean login() {
        int attempts = 0;
        while (attempts < 3) {
            System.out.print("\nPassword: ");
            String pw = sc.nextLine();
            if (pw.equals("007")) {
                System.out.println("\nWelcome to Jooma School System :)\n");
                return true;
            } else {
                attempts++;
                System.out.println("Wrong password! Attempt " + attempts);
            }
        }
        System.out.println("\nToo many attempts. Try again later.");
        return false;
    }

    // -------------------- ADD --------------------
    
    void handleAdd() {
        try {
            int id = 1;
            File allfile = new File("Student.txt");
            if (!allfile.exists()) allfile.createNewFile();
            else {
                try (BufferedReader br = new BufferedReader(new FileReader(allfile))) {
                    while (br.readLine() != null) id++;
                }
            }

            String studentId = String.format("%04d", id);
            System.out.println("\n----- Add Student -----\n");
            System.out.println("ID: " + studentId);

            System.out.print("Name: "); String name = sc.nextLine();
            System.out.print("Age: "); int age = Integer.parseInt(sc.nextLine());

            int year;
            while (true) {
                System.out.print("Year (1-3): ");
                year = Integer.parseInt(sc.nextLine());
                if (year >= 1 && year <= 3) break;
                System.out.println("** Please enter Year only 1-3 **");
            }

            int room;
            while (true) {
                System.out.print("Room (1-3): ");
                room = Integer.parseInt(sc.nextLine());
                if (room >= 1 && room <= 3) break;
                System.out.println("** Please enter Room only 1-3 **");
            }

            System.out.print("Confirm add student? (Y/N): ");
            String confirm = sc.nextLine();
            if (confirm.equalsIgnoreCase("Y")) {
                add_student(studentId, name, age, year, room);
            } else {
                System.out.println("Cancelled.");
            }
        } catch (IOException e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    void add_student(String id, String name, int age, int y, int room) throws IOException {
        File allfile = new File("Student.txt");
        if (!allfile.exists()) allfile.createNewFile();

        String filename = "K" + y + "_" + room + ".txt";
        File classFile = new File(filename);
        if (!classFile.exists()) {
            classFile.createNewFile();
            System.out.println("Created file: " + filename);
        }

        String studentData = id + " " + name + " " + age + " " + y + " " + room;

        try (FileWriter fw = new FileWriter(classFile, true);
             PrintWriter out = new PrintWriter(fw)) {
            out.println(studentData);
        }

        try (FileWriter fwAll = new FileWriter(allfile, true);
             PrintWriter outAll = new PrintWriter(fwAll)) {
            outAll.println(studentData);
        }

        System.out.println("Student added successfully!");
    }

    // -------------------- SHOW --------------------

    void handleShow() {
        while (true) {
            System.out.println("\n----- Show Information -----\n");
            System.out.println("1. All Student information");
            System.out.println("2. Student information by Year");
            System.out.println("3. Student information by Room");
            System.out.println("0. Back to Main Menu");
            System.out.print("Select: ");
            int choice;
            try { choice = Integer.parseInt(sc.nextLine()); }
            catch (NumberFormatException e) { System.out.println("Invalid"); continue; }

            if (choice == 0) break;
            switch (choice) {
                case 1: showAll(); break;
                case 2: showByYear(); break;
                case 3: showByRoom(); break;
                default: System.out.println("Only 0-3!");
            }
        }
    }

    void showAll() {
        File file = new File("Student.txt");
        if (!file.exists()) { System.out.println("No student data found."); return; }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            System.out.println("\n----- All Student information-----\n");
            System.out.printf("%-5s %-10s %-4s %-5s %-5s\n", "ID", "Name", "Age", "Year", "Room");
            String line;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(" ");
                System.out.printf("%-5s %-10s %-4s %-5s %-5s\n", arr[0], arr[1], arr[2], arr[3], arr[4]);
            }
        } catch (IOException e) { System.out.println("Error reading file."); }
    }

    void showByYear() {
        try {
            System.out.println("\n----- All Student information by Year -----");
            int year;
            while (true) {
                System.out.print("\nYear (1-3): ");
                year = Integer.parseInt(sc.nextLine());
                if (year >= 1 && year <= 3)
                break;
            }
            boolean found = false;
            System.out.println("\n----- Student information K"+year+" -----\n");
            for (int r = 1; r <= 3; r++) {
                String fname = "K" + year + "_" + r + ".txt";
                File f = new File(fname);
                if (!f.exists()) continue;

                try (BufferedReader br = new BufferedReader(new FileReader(f))) {
                String firstLine = br.readLine();
                if (firstLine == null || firstLine.trim().isEmpty()) {continue;}}

                found = true;
                System.out.println("\n--> " + fname+"\n");
                try (BufferedReader br = new BufferedReader(new FileReader(f))) {
                    System.out.printf("%-5s %-10s %-4s %-5s %-5s\n\n", "ID", "Name", "Age", "Year", "Room");
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] arr = line.split(" ");
                        System.out.printf("%-5s %-10s %-4s %-5s %-5s\n", arr[0], arr[1], arr[2], arr[3], arr[4]);
                    }
                }
            }
            if (!found) System.out.println("\nNo data for Year " + year);
        } catch (IOException e) { System.out.println("Error reading files."); }
    }

    void showByRoom() {
        try {
            System.out.println("\n----- All Student information by Room -----\n");
            int year, room;
            while (true) {
                System.out.print("Year (1-3): ");
                year = Integer.parseInt(sc.nextLine());
                if (year >= 1 && year <= 3) break;
            }
            while (true) {
                System.out.print("Room (1-3): ");
                room = Integer.parseInt(sc.nextLine());
                if (room >= 1 && room <= 3) break;
            }
            String fname = "K" + year + "_" + room + ".txt";
            File f = new File(fname);
            if (!f.exists()) { System.out.println("No data for this class."); return; }
            try (BufferedReader br = new BufferedReader(new FileReader(f))) {
                System.out.println("\n----- Student in Room K"+year+"_"+room+" -----\n");
                System.out.printf("%-5s %-10s %-4s %-5s %-5s\n", "ID", "Name", "Age", "Year", "Room");
                String line;
                while ((line = br.readLine()) != null) {
                    String[] arr = line.split(" ");
                    System.out.printf("%-5s %-10s %-4s %-5s %-5s\n", arr[0], arr[1], arr[2], arr[3], arr[4]);
                }
            }
        } catch (IOException e) { System.out.println("Error reading file."); }
    }

    // -------------------- SEARCH --------------------
    
    void handleSearch() {
        System.out.println("\n----- Search students information -----\n");
        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();
        File file = new File("Student.txt");
        if (!file.exists()) { System.out.println("No data."); return; }
        boolean found = false;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith(id + " ")) {
                    String[] arr = line.split(" ");
                    System.out.printf("\n%-5s %-10s %-4s %-5s %-5s\n", "ID", "Name", "Age", "Year", "Room");
                    System.out.printf("%-5s %-10s %-4s %-5s %-5s\n", arr[0], arr[1], arr[2], arr[3], arr[4]);
                    found = true;
                    break;
                }
            }
            if (!found) System.out.println("Student ID not found.");
        } catch (IOException e) { System.out.println("Error reading file."); }
    }

    // -------------------- EDIT --------------------

    void handleEdit() {
        System.out.println("\n----- Edit students information -----\n");
        System.out.print("Enter Student ID to edit: ");
        String id = sc.nextLine();

        File file = new File("Student.txt");
        if (!file.exists()) {System.out.println("No student data."); return;}

        String oldLine = "";
        String[]oldData = null;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith(id + " ")) {
                    oldLine = line;
                    oldData = line.split(" ");
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        if (oldLine.isEmpty()) {
            System.out.println("Student ID not found.");
            return;
        }

        System.out.print("New Name (" + oldData[1] + "): ");
        String newName = sc.nextLine();
        if (newName.isEmpty()) newName = oldData[1];

        System.out.print("New Age (" + oldData[2] + "): ");
        String newAge = sc.nextLine();
        if (newAge.isEmpty()) newAge = oldData[2];

        int newY;
        while (true) {
            System.out.print("New Year (" + oldData[3] + "): ");
            String input = sc.nextLine();
            if (input.isEmpty()) {
                newY = Integer.parseInt(oldData[3]);
                break;
            }
            newY = Integer.parseInt(input);
            if (newY >= 1 && newY <= 3) break;
        }

        int newR;
        while (true) {
            System.out.print("New Room (" + oldData[4] + "): ");
            String input = sc.nextLine();
            if (input.isEmpty()) {
                newR = Integer.parseInt(oldData[4]);
                break;
            }
            newR = Integer.parseInt(input);
            if (newR >= 1 && newR <= 3) break;
        }

        System.out.print("Confirm edit student? (Y/N): ");
        String confirm = sc.nextLine();
        if (!confirm.equalsIgnoreCase("Y")) {
            System.out.println("Canceled.");
            return;
        }

        try {
            edit_student(id, newName, newAge, String.valueOf(newY), String.valueOf(newR));
        } catch (IOException e) {
            System.out.println("Error editing student: " + e.getMessage());
        }
    }

    void edit_student(String id, String newName, String newAge, String newY, String newR) throws IOException {
        File origFile = new File("Student.txt");
        File tempFile = new File("temp.txt");

        String oldLine = "";
        String oldY = "";
        String oldR = "";

        try (BufferedReader br = new BufferedReader(new FileReader(origFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith(id + " ")) {
                    oldLine = line;
                    String[] arr = line.split(" ");
                    oldY = arr[3];
                    oldR = arr[4];
                    break;
                }
            }
        }

        if (oldLine.isEmpty()) {System.out.println("Student ID not found.");
            return;
        }

        String newLine = id + " " + newName + " " + newAge + " " + newY + " " + newR;

        // แก้ไขใน Student.txt
        try (BufferedReader br = new BufferedReader(new FileReader(origFile));
             PrintWriter pw = new PrintWriter(new FileWriter(tempFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.equals(oldLine)) pw.println(newLine);
                else pw.println(line);
            }
        }
        origFile.delete();
        tempFile.renameTo(origFile);

        // ลบจากไฟล์เก่า
        String oldClassFile = "K" + oldY + "_" + oldR + ".txt";
        File classFileOld = new File(oldClassFile);
        File tempClassOld = new File("tempClass.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(classFileOld));
             PrintWriter pw = new PrintWriter(new FileWriter(tempClassOld))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.equals(oldLine)) pw.println(line);
            }
        }
        classFileOld.delete();
        tempClassOld.renameTo(classFileOld);

        // เพิ่มไปไฟล์.หม่
        String newClassFile = "K" + newY + "_" + newR + ".txt";
        File classFileNew = new File(newClassFile);
        if (!classFileNew.exists()) classFileNew.createNewFile();

        ArrayList<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(classFileNew))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        }

        lines.add(newLine);

        Collections.sort(lines, new Comparator<String>() {
            public int compare(String a, String b) {
                int idA = Integer.parseInt(a.split(" ")[0]);
                int idB = Integer.parseInt(b.split(" ")[0]);
                return Integer.compare(idA, idB);
            }
        });

        try (PrintWriter pw = new PrintWriter(new FileWriter(classFileNew))) {
            for (String s : lines) pw.println(s);
        }

        System.out.println("Student updated successfully!");
    }


    // -------------------- DELETE --------------------

    void handleDelete() {
        System.out.println("\n----- Delete students information -----\n");
        System.out.print("Enter Student ID to delete: ");
        String id = sc.nextLine();
        System.out.print("Confirm delete? (Y/N): ");
        String confirm = sc.nextLine();
        if (!confirm.equalsIgnoreCase("Y")) { System.out.println("Canceled."); return; }
        try { del_student(id); }
        catch (IOException e) { System.out.println("Error deleting student: " + e.getMessage()); }
    }

    void del_student(String ID) throws IOException {
        File origFile = new File("Student.txt");
        File tempFile = new File("temp.txt");

        String delLine = "";
        String delY = "";
        String delR = "";

        try (BufferedReader br = new BufferedReader(new FileReader(origFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith(ID + " ")) {
                    delLine = line;
                    String[] arr = line.split(" ");
                    delY = arr[3];
                    delR = arr[4];
                    break;
                }
            }
        }
        if (delLine.isEmpty()) { System.out.println("Student ID not found."); return; }

        try (BufferedReader br = new BufferedReader(new FileReader(origFile));
             PrintWriter pw = new PrintWriter(new FileWriter(tempFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.equals(delLine)) pw.println(line);
            }
        }
        origFile.delete();
        tempFile.renameTo(origFile);

        String classFileName = "K" + delY + "_" + delR + ".txt";
        File classFile = new File(classFileName);
        File tempClass = new File("tempClass.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(classFile));
             PrintWriter pw = new PrintWriter(new FileWriter(tempClass))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.equals(delLine)) pw.println(line);
            }
        }
        classFile.delete();
        tempClass.renameTo(classFile);
        System.out.println("Student deleted successfully!");
    }
}
