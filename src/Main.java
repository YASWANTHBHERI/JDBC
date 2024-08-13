import com.studentmanage.Student;
import com.studentmanage.StudentDao;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Student Management App");

        Scanner sc = new Scanner(System.in);


        while(true){
            System.out.println("Press 1 for Add Students");
            System.out.println("Press 2 for Delete Students");
            System.out.println("Press 3 for Display Students");
            System.out.println("Press 4 for Exit");
            int input = sc.nextInt();
            sc.nextLine();
            if(input==1){
                System.out.println("Enter Student name");
                String name = sc.nextLine();

                System.out.println("Enter Student phone number");
                String phone = sc.next();
                sc.nextLine();

                System.out.println("Enter Student city");
                String city = sc.nextLine();

                Student st = new Student(name,city,phone);
                boolean res = StudentDao.insertIntoDB(st);
                if(res){
                    System.out.println("Student inserted successfully");
                }
                else{
                    System.out.println("Student insertion failed");
                }
                System.out.println(st);
            }else if(input==2){
                System.out.println("Enter Student Sid: ");
                int sid = sc.nextInt();
                boolean res = StudentDao.deleteStudent(sid);
                if(res){
                    System.out.println("Student deleted successfully...");
                }else System.out.println("something went wrong try again...");
            }else if(input==3){
                StudentDao.showAllStudents();
            } else if (input==4) {
                break;
            }
        }
        System.out.println("Thank you for using the Application...");
    }
}