public class TestStudent{
 public static void main(String[] args) {
try{
   String[] s=null;
   s[0]="Java";
   System.out.println(s[0]);
  }catch(Exception e) {
   System.out.println("Exception");
  }catch(NullPointerException e){
   System.out.println("NullPointerException");
  }
}

 }