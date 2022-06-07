import java.util.Arrays;
import java.util.Scanner;

class David_OE3{
    static void createArray(int[] numbers){
        Scanner inp = new Scanner(System.in);
        for(int i =0; i<numbers.length;i++){
            System.out.print("Input the value of cell "+ i+" : ");
            numbers[i] = inp.nextInt();
        }
        inp.close();
    }//end of create array

    static void printArray(int[] numbers){
        String display = Arrays.toString(numbers);
        System.out.println(display);
    }//end of print method

    static void bubbleSort(int[] numbers){
        System.out.println("Start sorting");
        for(int i = 0; i<numbers.length;i++){
            boolean flag = false;
            for(int j = 0; j<numbers.length-1;j++){
                //if the numbers is not in order
                if(numbers[j]>numbers[j+1]){//then swap
                    flag = true;
                    int temp = numbers[j];
                    numbers[j]= numbers[j+1];
                    numbers[j+1]=temp;
                }
            }
            if(!flag){
                    System.out.println("Already sorted");
                    return;
                }
        }
        System.out.print("Finish sorting");
    }//end of bubblesort method

    //BINARY SEARCH
    static boolean binarySearch(int[] numbers, int value){
        int low =0;
        int high = numbers.length-1;
        
        while(high >=low){
            int middle = (low + high)/2;

            if (numbers[middle]==value){
                return true;
            }
            if (numbers[middle]<value){
                low = middle +1;
            }
            if(numbers[middle]>value)
                high = middle -1;
        }//end of while loop
        return false;//The value was not found
    }//end of binarySearch method
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //ARRAY CREATION
        System.out.print("Input the size of the array : ");
        int size = in.nextInt();
        int numbers[] = new int[size];
        for(int i =0; i<numbers.length;i++){
            System.out.print("Input the value of cell "+ i+" : ");
            numbers[i] = in.nextInt();
        }
        System.out.print("The array: ");
        printArray(numbers);

        
        //SORT THEN SEARCH
        
        System.out.println("===========================");
        bubbleSort(numbers);
        printArray(numbers);
        System.out.println("===========================");
        System.out.print("Value to search : ");
        int value = in.nextInt();
        
        if(!binarySearch(numbers, value)){
            System.out.println("The value is not in the array!");
        }
        else{
            System.out.println("The value is in the array!");
        }
        System.out.println("===========================");
        in.close();//closes the input object
    }//end of main method
}//end of class