
public class RoadBike extends Bike implements RoadParts{
	
	private int  tyreWidth, postHeight;
	
	public RoadBike()
	{
		this("drop", "racing", "tread less", "razor", 19, 20, 22);
	}//end constructor
	
	public RoadBike(int postHeight)
	{
		this("drop", "racing", "tread less", "razor", 19, 20, postHeight);
	}//end constructor
		
	public RoadBike(String handleBars, String frame, String tyres, String seatType, int numGears,
			int tyreWidth, int postHeight) {
		super(handleBars, frame, tyres, seatType, numGears);
		this.tyreWidth = tyreWidth;
		this.postHeight = postHeight;
	}//end constructor
	
	public void printDescription()
	{
		super.printDescription();
		System.out.println("This Roadbike bike has " + this.tyreWidth + "mm tyres and a post height of " + this.postHeight + ".");
	}//end method printDescription

	@Override
	public int getTyreWidth() {
		return this.tyreWidth;
	}//end method 

	@Override
	public void setTyreWidth(int newValue) {
		this.tyreWidth = newValue;
	}//end method 

	@Override
	public int getPostHeight() {
		return this.postHeight;
	}//end method 

	@Override
	public void setPostHeight(int newValue) {
		this.postHeight = newValue;
	}//end method 
}//end class RoadBike
