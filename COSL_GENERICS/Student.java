import java.util.ArrayList;
import java.util.Collection;

public class Student {
    public static void main(String[] args) {
        ArrayList<String> studentNames = new ArrayList<>();

        addStudents(studentNames);
        //Collection.sort(studentNames);
        displayStudents(studentNames);
    }//end of main
    
    static void addStudents(ArrayList<String> studentNames){
        studentNames.add("Christine");
        studentNames.add("Christian");
        studentNames.add("Kier");
    }

    static void displayStudents(ArrayList<String> studentNames){
        for(String student : studentNames){
            System.out.println("Student names: "+ student );
        }
    }
}//end of class
