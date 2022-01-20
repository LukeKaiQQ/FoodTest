package tw.com.fcb.foodTest;

public class Food {
	private String foodID;
	private String foodName;
	private String foodAddress;
	private int foodPrice;
	
	@Override
	public String toString() {
		return "Food [foodID=" + foodID + ", foodName=" + foodName + ", foodAddress=" + foodAddress + ", foodPrice="
				+ foodPrice + "]";
	}
	
	public String getFoodID() {
		return foodID;
	}
	public void setFoodID(String foodID) {
		this.foodID = foodID;
	}
	
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getFoodAddress() {
		return foodAddress;
	}
	public void setFoodAddress(String foodAddress) {
		this.foodAddress = foodAddress;
	}
	public int getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(int foodPrice) {
		this.foodPrice = foodPrice;
	}
}
