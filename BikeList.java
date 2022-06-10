package bikeproject;
import java.util.ArrayList;
import java.util.Random;

class BikeList{
	private int mountainBikeSales = 0 , roadBikeSales = 0;
	
	static void fillArray(ArrayList<Bike> bikes) {
		Random rand = new Random();//instance of random num
		 for (int i = 0;i<10;i++) {
			 int decider = rand.nextInt(0,2);
			 if(decider < 1)
				 bikes.add(new MountainBike());
			 else
				 bikes.add(new RoadBike());
		 }//end of for loop	 
	}//end of fillArray method
	
	static void displayStock(ArrayList<Bike> bikes){
		for(Bike bike: bikes ) {
			bike.printDescription();
		}// end of for each loop
		
	}//end of displayStock method
	
	static int calculateStock(ArrayList<Bike> bikes) {
		int bikesSold = 0;// counts the mountainBike object
		for (Bike bike: bikes) {
			if(bike instanceof MountainBike) {
				bikesSold++;
			}
		}//end of for each loop	
		return bikesSold;
	}//end of calculateStock method
	
	static void displayBikeNumbers(ArrayList<Bike> bikes) {
		int mb = calculateStock(bikes),rb = bikes.size() - mb;
		System.out.println("Stock Levels\nWe have "+ mb +" Mountain Bikes in stock");
		System.out.println("We have "+ rb +" Road Bikes in stock");
	}//end of displayBikeNumbers method
	
	public static void main (String [] args) {
		ArrayList<Bike> bikes = new ArrayList<Bike>();
		
		//call the methods
		fillArray(bikes);
		displayStock(bikes);
		displayBikeNumbers(bikes);
	}

}