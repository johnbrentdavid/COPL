
import java.util.Scanner;
// THIS IS THE DRIVER CLASS
public class converter {
    
    public static void main(String[] args) {
        boolean repeat = true;
        String input;
        Scanner in = new Scanner(System.in);
        int dcs;
        
//MAIN LOOP
        while(repeat){
            System.out.print("~Labels for CONVERTION~\npte -> Peso to Euro\nptd -> Peso to Dollar\netp -> Euro to Peso\ndtp -> Dollar to Peso\nFor example (123.00 ptd,199.99 etp)\nEnter the Amount to be Converted then the convertion> ");
            input = in.nextLine();
            if(input.matches("\\d*.\\d*\\s[ped]t[ped]")){//check if user input is like this (100.00 pte,199 etp,etc.)
                Convertion c = new Convertion(Amount(input),C1(input),C2(input));
                c.printRates();
                c.printConvertion();
                System.out.println(c.getCAmount()+" "+c.getCurrency2()+"/s");
                System.out.print("[0] - Exit the Program\n[1] - Convert Again\nDecision>");
                dcs = in.nextInt();
                if(dcs == 0){
                    repeat = false;
                }
                else{
                    input = "";
                }
                
            }
            else{
                System.out.println("Wrong Input! Try AGAIN!");
                System.out.println("\033[H\033[2J");
                System.out.flush(); 
            }
        }//end of while loop
        in.close();
    }//end of main method

//DEFINED METHODS
    public static String reverseString(String str){  
        char ch[]=str.toCharArray();  
        String rev="";  
        for(int i=ch.length-1;i>=0;i--){  
            rev+=ch[i];  
        }  
        return rev;  
    }  
    public static double Amount(String input){
        String a1 = "2.0";
        for(int i=0;i<input.length();i++){  
            if(input.charAt(i)== ' '){
                a1 = input.substring(0,i-1);
            }
        } 
        double amount= Double.parseDouble(a1);
        return amount;
    }
    public static String C1(String input){
        String c1=reverseString(input);
        if(c1.charAt(2)=='p')
            return "Peso";
        else if(c1.charAt(2)=='d')
            return "Dollar";
        else if(c1.charAt(2)=='e')
            return "Euro";
        return "";
    }
    public static String C2(String input){
        String c1=reverseString(input);
        if(c1.charAt(0)=='p')
            return "Peso";
        else if(c1.charAt(0)=='d')
            return "Dollar";
        else if(c1.charAt(0)=='e')
            return "Euro";
        return "";
    }
}
