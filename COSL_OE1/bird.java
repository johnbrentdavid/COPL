public class bird extends animal {
    private String size,diet;

    public bird(String breed,String color,String size,String diet){
        super(breed,color);
        this.size = size;
        this.diet = diet;
    }//end of constructor

    public void getBird(){
        System.out.println("Bird Breed : "+ getBreed());
        System.out.println("Bird Color : "+ getColor());
        System.out.println("Bird Size : "+ size);
        System.out.println("Bird Diet : "+ diet);
    }

    public void setBird(String size, String diet){
        this.size = size;
        this.diet = diet;
    }

}
