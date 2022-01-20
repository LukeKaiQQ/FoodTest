package tw.com.fcb.foodTest;

import java.util.*;

public class FoodServiceImpl implements FoodService{
	Map<String, Food> foodsMap = new HashMap<String, Food>();
	Food[] foodArr = new Food[3];
	
	public FoodServiceImpl(){
		for(int i = 0 ; i < foodArr.length ; i++) {
			foodArr[i] = new Food();
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the foodID: ");
			String foodString = scanner.next();
			foodArr[i].setFoodID(foodString);
			
			System.out.println("Enter the foodName");
			String nameString = scanner.next();
			foodArr[i].setFoodName(nameString);
			
			System.out.println("Enter the foodAddress: ");
			String addressString = scanner.next();
			foodArr[i].setFoodAddress(addressString);
			
			System.out.println("Enter the foodPrice: ");
			int priceInt = scanner.nextInt();
			foodArr[i].setFoodPrice(priceInt);
			
			foodsMap.put(foodArr[i].getFoodID(), foodArr[i]);
		}
		
//		foodArr[0].setFoodID("001");
//		foodArr[0].setFoodName("牛肉麵");
//		foodArr[0].setFoodAddress("台北市...");
//		foodArr[0].setFoodPrice(300);
//		
//		foodArr[1].setFoodID("002");
//		foodArr[1].setFoodName("豬腳飯");
//		foodArr[1].setFoodAddress("新北市...");
//		foodArr[1].setFoodPrice(300);
//		
//		foodArr[2].setFoodID("003");
//		foodArr[2].setFoodName("牛排");
//		foodArr[2].setFoodAddress("高雄市...");
//		foodArr[2].setFoodPrice(500);
//		
//		for(int i = 0 ; i < foodArr.length ; i++)
//			foodsMap.put(foodArr[i].getFoodID(), foodArr[i]);
	}
	
	@Override
	public Food getFoodID(String foodID) {
		return foodsMap.get(foodID);
	}
	
	@Override
	public List<Food> getFoodName(String foodName){
		List<Food> foodList = new ArrayList<Food>();
		System.out.println(foodList);
		for(String key : foodsMap.keySet()) {
			System.out.println("This key is " + key);
			Food thisFood = foodsMap.get(key);
			
			if(thisFood.getFoodName().equals(foodName)) {
				foodList.add(thisFood);
			}
			else {
				System.out.println("The food " + thisFood.getFoodName() + "not exist");
			}
		}
		return foodList;
	}
	
	public void foodInfo() {
		for(int i = 0 ; i < foodArr.length ; i++)
			System.out.println(foodArr[i].toString());
	}
}
