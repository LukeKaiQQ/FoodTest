package tw.com.fcb.foodTest;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Test;

class FoodServiceTest {
	
	@Test
	void testFoodID() {
		FoodService service = new FoodServiceImpl();
		Food food = service.getFoodID("001");
		assertEquals("牛肉麵", food.getFoodName());
	}
	
	@Test
	void testGetFood() {
		FoodService service = new FoodServiceImpl();
		List<Food> foods = service.getFoodName("牛肉麵");
		assertEquals(1, foods.size());
	}
}
