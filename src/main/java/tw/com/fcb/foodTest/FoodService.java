package tw.com.fcb.foodTest;

import java.util.List;

public interface FoodService {
	public Food getFoodID(String foodID);
	
	public List<Food> getFoodName(String foodName);
	
	public void readFoodFile();
	
	public void writeFoodFile(String data);
	
	public void foodInsert();
	
	public void foodUpdate();
	
	public void foodDelete();
	
	public String foodToString(String foodId);
	
	public void foodInfo();
	
	
}
