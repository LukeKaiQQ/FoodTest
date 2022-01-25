package tw.com.fcb.foodTest;

import java.util.*;
import java.io.*;

public class FoodServiceImpl implements FoodService{
	Map<String, Food> foodsMap = new HashMap<String, Food>();
	
	public FoodServiceImpl(){
		readFoodFile();
	}
	
	// Read food.txt
	@Override
	public void readFoodFile() {
		try {
			FileReader fileReader = new FileReader("food.txt");
			BufferedReader bReader = new BufferedReader(fileReader);
			
			String line = "";
			while((line = bReader.readLine()) != null) {
				String[] tokenStrings = line.split(",");
				for(int i = 0 ; i < tokenStrings.length ; i++){
					Food food = new Food();
					food.setFoodID(tokenStrings[0]);
					food.setFoodName(tokenStrings[1]);
					food.setFoodAddress(tokenStrings[2]);
					food.setFoodPrice(tokenStrings[3]);
					food.setFoodStar(tokenStrings[4]);
					foodsMap.put(food.getFoodID(), food);
				}
			}
			bReader.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	// Write food.txt
	@Override
	public void writeFoodFile(String data) {
		try {
			FileWriter fileWriter = new FileWriter("food.txt",true);
			BufferedWriter bWriter = new BufferedWriter(fileWriter);
			bWriter.write(data);
			bWriter.newLine();
			bWriter.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	// foodInsert
	@Override
	public void foodInsert() {
		while(true) {
			try {
				Food food = new Food();
				
				Scanner scanner = new Scanner(System.in);
				System.out.print("Enter the foodID: ");
				String foodId = scanner.next();
				System.out.print("Enter the foodName: ");
				String foodName = scanner.next();
				System.out.print("Enter the foodAddress: ");
				String foodAddress = scanner.next();
				System.out.print("Enter the foodPrice: ");
				String foodPrice = scanner.next();
				System.out.print("Enter the foodStar: ");
				String foodStar = scanner.next();
				
				// Quit...
				if(foodId.equals("000") || Integer.parseInt(foodPrice) < 0) {
					System.out.println("Data Insert Not Success.....");
					break;
				}
				else {
					food.setFoodID(foodId);
					food.setFoodName(foodName);
					food.setFoodAddress(foodAddress);
					food.setFoodPrice(foodPrice);
					food.setFoodStar(foodStar);
					foodsMap.put(food.getFoodID(), food);
					
					String data = foodToString(foodId);
					writeFoodFile(data);
				}
			}
			catch(InputMismatchException e) {
				System.out.println(e.getMessage());
			}
			
			System.out.println("Insert success.....");
			System.out.println("Foods Info......");
		}
	}
	
	// foodUpdate
	@Override
	public void foodUpdate() {
		// 無DB做法，檔案清檔再重寫資料
		try {
			new PrintWriter("food.txt").close();
		} 
		catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		String foodId = "";
		while(true) {
			try {
				Food food = new Food();
				
				Scanner scanner = new Scanner(System.in);
				System.out.print("Enter the foodID: ");
				foodId = scanner.next();
				if(foodsMap.get(foodId) == null) {
					System.out.println("商品不存在...");
					break;
				}
				else {
					System.out.print("Enter the foodName: ");
					String foodName = scanner.next();
					System.out.print("Enter the foodAddress: ");
					String foodAddress = scanner.next();
					System.out.print("Enter the foodPrice: ");
					String foodPrice = scanner.next();
					System.out.print("Enter the foodStar: ");
					String foodStar = scanner.next();
					
					foodsMap.get(foodId).setFoodName(foodName);
					foodsMap.get(foodId).setFoodAddress(foodAddress);
					foodsMap.get(foodId).setFoodPrice(foodPrice);
					foodsMap.get(foodId).setFoodStar(foodStar);
					
					for(String key : foodsMap.keySet()) {
						writeFoodFile(foodToString(key));
					}
				}
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	// foodDelete
	@Override
	public void foodDelete() {
		// 無DB做法，檔案清檔再重寫資料
		try {
			new PrintWriter("food.txt").close();
		} 
		catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		while(true) {
			try {
				Food food = new Food();
				
				Scanner scanner = new Scanner(System.in);
				System.out.print("Enter the foodID: ");
				String foodId = scanner.next();
				if(foodsMap.get(foodId) == null) {
					System.out.println("商品不存在...");
					break;
				}
				else {
					foodsMap.remove(foodId);
					for(String key : foodsMap.keySet()) {
						writeFoodFile(foodToString(key));
					}
				}
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	// foodInfo
	@Override
	public void foodInfo() {
		for(String key : foodsMap.keySet()) {
			Food foods = foodsMap.get(key);
			System.out.println(foods);
		}
	}
	
	// foodToString
	@Override
	public String foodToString(String foodId) {
		return foodsMap.get(foodId).getFoodID() + "," + 
				foodsMap.get(foodId).getFoodName() + "," + 
				foodsMap.get(foodId).getFoodAddress() + "," + 
				foodsMap.get(foodId).getFoodPrice() + "," + 
				foodsMap.get(foodId).getFoodStar();
	}
	
	// getFoodId
	@Override
	public Food getFoodID(String foodID) {
		System.out.println(foodsMap.get(foodID).toString());
		return foodsMap.get(foodID);
	}
	
	// getFoodName
	@Override
	public List<Food> getFoodName(String foodName){
		List<Food> foodList = new ArrayList<Food>();
		for(String key : foodsMap.keySet()) {
			System.out.println("This key is " + key);
			Food thisFood = foodsMap.get(key);
			
			if(thisFood.getFoodName().equals(foodName)) {
				foodList.add(thisFood);
			}
			else {
				System.out.println("The food " + thisFood.getFoodName() + " not exist");
			}
		}
		return foodList;
	}
}
