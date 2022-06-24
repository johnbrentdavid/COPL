import java.util.*;
//Step B
public class Employee {
    private final String name,username,email;
    public String password;
    public Employee(){
        this.name = setName();
        this.username = setUserName(name);
        this.email = setEmail(username);
        this.password = setPassword(username);
    }
//Step C
    public void toDisplay(){
        String reversed = reverse(name);
        System.out.println("Employee Details\nName\t\t: "+name+"\nUsername\t: "+username+"\nEmail\t\t: "+email+"\nPassword\t: "+password+"");
        System.out.print("Reversed String : \t"+reversed);
    }
//Step D
    private int countChars(String word,char letter){
        int counter=0;//step f
        for(int i=0; i < word.length(); i++){
            if(letter == word.charAt(i)){
                counter++;
            }
        }
        return counter;
    }
//STEP F
    public String setName(){
        Scanner in = new Scanner(System.in);
        String name;
        System.out.print("Please Enter Your Name :");
        name = in.nextLine();
        in.close();
        return name;
    }
//Step G done
    public String setUserName(String name){
        String username = "";
        for(int i=0;i<name.length();i++){
            if(name.charAt(i) == ' '){
                username+=name.substring(0, i).toLowerCase();//saves the firstname before the space and lowercases it
                username+='.';
                username+=name.substring(i+1,name.length()).toLowerCase();//saves the last after the space and lowercases it
            }
        }
        return username.toLowerCase();//just to make sure that everything is lowercased.
    }
//Step H
    public String setEmail(String username){
        String email = "";
        for(int i=0;i<username.length();i++){
            if(i==0){//add the initial letter
                email+=username.charAt(i);
            }
            if(username.charAt(i) == '.'){//add the lastname to the email
                email+=username.substring(i+1,username.length());
                email+="@oracleacademy.Test";
            }
        }//end of for loop
        return email;
    } 
//Step I
    public String setPassword(String username){
        String pass="";
        int limit = 8,len = username.length();
        //you need to uppercase the first letter first before copying the rest if it is not a vowel
        if(username.charAt(0)=='a'||username.charAt(0)=='e'||username.charAt(0)=='i'||username.charAt(0)=='o'||username.charAt(0)=='u'){
            pass+='*';
        }
        else{
            pass+=username.substring(0,1).toUpperCase();
        }

        //LENGTH CHECKER
        if(len < limit){//checks if the length is too short
            for(int i=1;i<len;i++){//assign the values every single one of them
                if(username.charAt(i)=='a'||username.charAt(i)=='e'||username.charAt(i)=='i'||username.charAt(i)=='o'||username.charAt(i)=='u'){
                    pass+='*';
                }
                else{
                    pass+=username.charAt(i);
                }
            }
            //Needs a while loop to satisfy the password limit
            while (len != limit){
                pass+='*';
            }
        }
        else{
            for(int i=1;i<limit;i++){//assign the values every single one of them
                if(username.charAt(i)=='a'||username.charAt(i)=='e'||username.charAt(i)=='i'||username.charAt(i)=='o'||username.charAt(i)=='u'){
                    pass+='*';
                }
                else{
                    pass+=username.charAt(i);
                }
            }
        }
        return pass;
    }
//Part 2 REVERSE THE STRING
    public String reverse(String str){ 
        String strRev = "";
        for(int i=str.length()-1;i>=0;i--)
            strRev+=str.charAt(i);
            return strRev;//endfor return strRev;
    }//end method reverse


}//end of class
