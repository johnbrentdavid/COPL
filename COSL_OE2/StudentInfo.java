import java.util.Scanner;

public class StudentInfo {
    //Misc methods
    public static void askUser(){
        System.out.print("=================================\nFill out the missing information/s\nStudent Number: ");
    }
    public static void main(String[] args) {
        String studentNo,program;
        
        Scanner in = new Scanner (System.in);

        askUser();
        studentNo = in.nextLine();
        System.out.print("Program: ");
        program = in.nextLine();
        Student s1 = new Student(studentNo,program);

        System.out.println("=================================\n\tSTUDENT INFORMATION\n---------------------------------");
        System.out.println("STUDENT NAME: "+s1.getStudentName());
        System.out.println("DEPARTMENT: "+s1.getDepartment());
        System.out.println("STUEDNT NUMBER: "+s1.getStudentNo());
        System.out.println("PROGRAM: "+s1.getProgram());
        System.out.println("=================================");
        System.out.print("Change Program: ");

        program = in.nextLine();
        s1.setProgram(program);

        System.out.println("=================================\n   UPDATED STUDENT INFORMATION\n---------------------------------");
        System.out.println("STUDENT NAME: "+s1.getStudentName());
        System.out.println("DEPARTMENT: "+s1.getDepartment());
        System.out.println("STUEDNT NUMBER: "+s1.getStudentNo());
        System.out.println("PROGRAM: "+s1.getProgram());
        System.out.println("=================================");

    }//end method main
}//end class StudentInfo