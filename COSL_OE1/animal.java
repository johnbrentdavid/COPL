public class animal{
    //Object Variables
    public String breed, color;

    public animal(String breed, String  color){
        this.breed = breed;
        this.color = color;
    }//end of constructor

    public String getBreed(){
        return breed;
    }

    public String getColor(){
        return color;
    }

    public void setBreed(String breed){
        this.breed = breed;
    }
    public void setColor(String color){
        this.color = color;
    }

}