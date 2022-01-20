package tw.com.fcb.foodTest;

public class FoodApp {

	public static void main(String[] args) {
		FoodServiceImpl serviceImpl = new FoodServiceImpl();
		serviceImpl.foodInfo();
		//System.out.println(serviceImpl.getFoodName("牛肉麵"));
	}
}
