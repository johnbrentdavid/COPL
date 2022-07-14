

public class Convertion implements iconvertion{
    
    public double amount;
    public final double ptd =.018,dtp=56.31,pte=.018,etp=57;//The base value is 1 for each convertion
    public String currency1,currency2;
//CONSTRUCTOR
    public Convertion(double amount,String currency1,String currency2){
        this.amount = amount;
        this.currency1 = currency1;
        this.currency2 = currency2;
    }

//SETTER METHODS
    public void changeAmount(double newAmount){
        this.amount = newAmount;
    }
    public void changeCurrency(String newCurrency){
        this.currency1 = newCurrency;
    }
    public void changeToCurrency(String newCurrency){
        this.currency2 = newCurrency;
    }

//GETTER METHODS
    public double getAmount(){
        return this.amount;
    }
    public double getCAmount(){
        switch (type()){
            case "pte":
                return amount*pte;
            case "ptd":
                return amount*ptd;
            case "etp":
                return amount*etp;
            case "dtp":
                return amount*dtp;
            default:
                return amount;
        }
    }
    public String getCurrency2(){
        return this.currency2;
    }
    public void printConvertion(){
        String last= currency1 +" to "+currency2;
        System.out.println(last);
    }
    public void printRates(){
        System.out.println("\nAs of "+date+
        "\n1 Peso to Dollar :\t"+ptd+
        "\n1 Peso to Euro :\t"+pte+
        "\n1 Dollar to Peso :\t"+dtp+
        "\n1 Euro to Peso :\t"+etp);
    }

//DEFINED METHODS
    public String type(){
        if (currency1=="Peso"&&currency2=="Euro")
            return "pte";
        else if (currency1=="Peso"&&currency2=="Dollar")
            return "ptd";
        else if (currency1=="Euro"&&currency2=="Peso")
            return "etp";
        else if (currency1=="Dollar"&&currency2=="Peso")
            return "dtp";
        return "SAME CURRENCY";
    }


}
