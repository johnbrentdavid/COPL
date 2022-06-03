public class Student {
    private static int studentId = 0;

 public Student(){
  studentId++;
 }
 public static int getStudentId(){
 return studentId;
 }
}

