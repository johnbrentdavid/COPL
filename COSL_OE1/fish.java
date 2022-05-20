public class fish extends animal {
    private String waterType;
    private String size;
    // Breed and color is extended from animal.java
    public fish(String breed,String waterType, String color,String size){
        super(breed,color);
        this.waterType = waterType;
        this.size = size;

    }//end of constructor

    public void getFish(){
        System.out.println("Fish Breed : "+ getBreed());
        System.out.println("Fish Water Type : " + waterType);
        System.out.println("Fish Color : "+ getColor());
        System.out.println("Fish Size : " + size);
    }

    public void setFish(String waterType){
        this.waterType = waterType;
    }

}
