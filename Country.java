import java.util.HashSet;
public class Country{

    public static void main(String[] args) {
        HashSet<String> country  = new HashSet<String>();

        country.add("USA");
        country.add("China");
        country.add("Russia");
        country.add("Germany");
        country.add("Japan");
        country.add("India");
        country.add("China");
        for(String countries : country){
            System.out.println(countries);
        }

    }
    
}