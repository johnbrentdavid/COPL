import java.util.regex.*;
import java.io.*;
public class AnswerKeyProblem {
    public static void main(String args[]) throws IOException{ 
        //read in the file provided by your teacher
        String fp = "D:/Lpu Laguna/2nd year 3rd sem/COP/Codes/REGEX/CodedAnswerKey.txt";
        BufferedReader codedAnswers = new BufferedReader(new FileReader(fp));
        //initialize String line as the first line of the file
        String line=codedAnswers.readLine();
        String answer = null;
        //keep reading each line and adding answers that match answer 
        answer = Check(line);
        //Possibilities to string answers until there are no more lines in the file
        while(line != null) { 
            //read the next line of the file
            if((line = codedAnswers.readLine())!= null){
                answer += Check(line);
            }//end of if
        }//endwhile
        System.out.println("Valid Answers : "+answer);
        System.out.println("Final Answers : "+ finalAnswers(answer) );
    }//end method main

    public static String Check(String line){//checks if the line is viable or not
        //START OF CODING
        String answer=null;//this keeps the potentially correct answers
        String regex = "^[a-fA-F]";
        for(int i=0;i<=line.length();i+=2){
            if(Pattern.matches(regex,line)){
                answer+=line.substring(i,i+1);
                return line;
            }
        }//end of for loop*/
        return "";
    }//end of Check method

    public static String finalAnswers(String line){
        String fanswer="",chr="";
        for(int i =0;i<line.length();i++){
            chr += line.charAt(i);
            //Checks if Char is e-f or E-F then change it if true
            switch (chr){
                case "e":
                    fanswer +="b";
                    break;
                case "E":
                    fanswer +="A";
                    break;
                case "f":
                    fanswer +="c";
                    break;
                case "F":
                    fanswer +="D";
                    break;
                default:
                    fanswer += chr;
            }//switch
            chr="";//resetter
        }//end of for loop
        return fanswer.toLowerCase();
    }//end of finalAnswers method

}//end class AnswerKeyProblem