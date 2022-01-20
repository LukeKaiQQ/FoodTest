package tw.com.fcb.foodTest;

import java.util.List;

public interface FoodService {
	public Food getFoodID(String foodID);
	
	public List<Food> getFoodName(String foodName);
}
