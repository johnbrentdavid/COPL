public class Student extends Item{//implements for INTERFACE || extends for ABSTRACT CLASS

    private String program;
    public String studentNo;

    public Student(String program, String studentNo){
    this.program = program;
    this.studentNo = studentNo;
    }//end constructor method
    //GET methods
    public String getStudentName() { return "John Brent David";}
    public String getDepartment() {return "COECS";}
    public String getStudentNo() {return studentNo;}
    public String getProgram() {return program;}
    //Set methods
    public void setProgram(String program){this.program = program;}
}//end class Student
