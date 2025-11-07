package Project;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

class Student {
    String name;
    int age;
    String classroom;

    Student(String name, int age, String classroom) {
        this.name = name;
        this.age = age;
        this.classroom = classroom;
    }

    @Override
    public String toString() {
        return "Name : " + name + " | Age : " + age + " | Classroom : " + classroom;
    }
}

public class KindergartenSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("\n Kindergarten System ");
            System.out.println("1 : Add student information");
            System.out.println("2 : Show all student information");
            System.out.println("3 : Search for students by name");
            System.out.println("4 : Delete student information");
            System.out.println("0 : exit");
            System.out.print("Select Menu: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Name : ");
                    String name = sc.nextLine();
                    System.out.print("Age : ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Classroom : ");
                    String classroom = sc.nextLine();

                    students.add(new Student(name, age, classroom));
                    System.out.println(" Completed !! ");
                    break;

                case 2:
                    System.out.println("\n List of all students ");
                    if (students.isEmpty()) {
                        System.out.println("No student information :(");
                    } else {
                        for (Student s : students) {
                            System.out.println(s);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Input student name : ");
                    String searchName = sc.nextLine();
                    boolean found = false;
                    for (Student s : students) {
                        if (s.name.equalsIgnoreCase(searchName)) {
                            System.out.println("Found : " + s);
                            found = true;
                        }
                    }
                    if (!found) System.out.println("Not found :(");
                    break;

                case 4:
                    System.out.print("Input student name : ");
                    String deleteName = sc.nextLine();
                    Student toRemove = null;
                    for (Student s : students) {
                        if (s.name.equalsIgnoreCase(deleteName)) {
                            toRemove = s;
                            break;
                        }
                    }
                    if (toRemove != null) {
                        students.remove(toRemove);
                        System.out.println("Delete Name Completed !! ");
                    } else {
                        System.out.println("Not found :(");
                    }
                    break;

                case 0:
                    System.out.println("Exit the program. Thank you :p");
                    return;

                default:
                    System.out.println("Wrong choice. Pls try again");
            }
        }
    }
}