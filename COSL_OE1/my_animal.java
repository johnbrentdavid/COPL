public class my_animal {

    public static void main(String[] args) {
        dog dog1 = new dog("Gorou","Malamute",60,"Brown");
        dog dogA = new dog("Chi Chi","Chihuahua","Arf Arf",20,"White");
        fish fish1= new fish("Bluefin","Ocean","Blueish","Large");
        bird bird1 = new bird("Philippine Eagle","Brown","Large","Monkey");

        System.out.println("======================\nDog Object\n----------------------");
        dog1.getDog();
        System.out.println("======================\nOverloaded Dog Object\n----------------------");
        dogA.getDogInfo();
        System.out.println("======================\nFish Object\n----------------------");
        fish1.getFish();
        System.out.println("======================\nBird Object\n----------------------");
        bird1.getBird();
    }  
}
