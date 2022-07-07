import java.util.regex.*;
import java.io.*;
public class AnswerKeyProblem {
    public static void main(String args[]) throws IOException{ 
        //read in the file provided by your teacher
        String fp = "D:/Lpu Laguna/2nd year 3rd sem/COP/Codes/REGEX/CodedAnswerKey.txt";
        BufferedReader codedAnswers = new BufferedReader(new FileReader(fp));
        //initialize String line as the first line of the file
        String line = codedAnswers.readLine();
        String answer = "";
        //keep reading each line and adding answers that match answer 
        //Possibilities to string answers until there are no more lines in the file
        while(line != null) { 
            //read the next line of the file
            if(line.matches("[a-fA-F]")){
                answer +=line;
            }//end of if
            line = codedAnswers.readLine();
        }//endwhile
        System.out.println("Valid Answers : "+answer);
        System.out.println("Final Answers : "+ finalAnswers(answer) );
    }//end method main
    
    public static String finalAnswers(String line){
        String fanswer="";
        fanswer = line.replaceAll("e", "b");
        fanswer = line.replaceAll("E", "A");
        fanswer = line.replaceAll("f", "c");
        fanswer = line.replaceAll("F", "D");
        return fanswer.toLowerCase();
    }//end of finalAnswers method

}//end class AnswerKeyProblem