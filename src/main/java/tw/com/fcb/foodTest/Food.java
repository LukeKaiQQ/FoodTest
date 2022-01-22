package tw.com.fcb.foodTest;

public class Food {
	private String foodID;
	private String foodName;
	private String foodAddress;
	private String foodPrice;
	private String foodStar;
	
	// toString
	@Override
	public String toString() {
		return "Food [foodID=" + foodID + ", foodName=" + foodName + ", foodAddress=" + foodAddress + ", foodPrice="
				+ foodPrice + ", foodStar=" + foodStar + "]";
	}
	
	// foodID
	public String getFoodID() {
		return foodID;
	}
	public void setFoodID(String foodID) {
		this.foodID = foodID;
	}
	
	// foodName
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	
	// foodAddress
	public String getFoodAddress() {
		return foodAddress;
	}
	public void setFoodAddress(String foodAddress) {
		this.foodAddress = foodAddress;
	}

	// foodPrice
	public String getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(String foodPrice) {
		this.foodPrice = foodPrice;
	}

	// foodStar
	public String getFoodStar() {
		return foodStar;
	}

	public void setFoodStar(String foodStar) {
		this.foodStar = foodStar;
	}
}
