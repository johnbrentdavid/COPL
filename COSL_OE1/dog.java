public class dog extends animal {
    private String name;
    private double wt; 
    private String barkNoise = "Woof";
    // Breed and color is extended from animal.java
    public dog(String name, String breed,double wt, String color){
        super(breed, color);//This is very important to use 
        this.name = name;
        this.wt = wt;
    }//end of constructor

    //Overloaded constructor
    public dog(String name,String breed,String noise,double wt,String color){
        super(breed,color);
        this.name = name;
        this.barkNoise = noise;
        this.wt = wt;
    }//end of overloaded constructor

    public void getDog(){
        System.out.println("Dog name : " + name);
        System.out.println("Dog breed : "+ getBreed());
        System.out.println("Dog weight :" + wt+"kg");
        System.out.println("Dog color : "+ getColor());
    }

    public void getDogInfo(){//Overload method
        System.out.println("Dog Name : " + name);
        System.out.println("Dog Breed : "+ getBreed());
        System.out.println("Dog Noise :" + barkNoise);
        System.out.println("Dog Weight :" + wt +"kg");
        System.out.println("Dog Color : "+ getColor());
    }

    public void setDog(String name,double wt){
        this.name = name;
        this.wt = wt;
    }
    public void setDogInfo(String name,String noise,double wt){//Overload method
        this.name = name;
        this.barkNoise = noise;
        this.wt = wt;
    }
}
