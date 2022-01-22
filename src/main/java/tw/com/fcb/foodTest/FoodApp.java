package tw.com.fcb.foodTest;

import java.util.Scanner;

public class FoodApp {
	public static void main(String[] args) {
		try(Scanner scanner = new Scanner(System.in)) {
			System.out.print("請輸入登入身分: 1).管理員 2).訪客: ");
			int userOption = scanner.nextInt();
			
			// Admin
			if(userOption == 1) {
				// password
				UserService userService = new UserService();
				System.out.print("請輸入密碼: ");
				String userPwd = scanner.next();
				String checkString = userService.CheckID(userPwd);
				
				// food-insert/delete/update/info
				FoodServiceImpl serviceImpl = new FoodServiceImpl();
				System.out.print("管理員功能: 1).新增 2).修改 3).刪除 4).查詢: ");
				int adminOption = scanner.nextInt();
				
				if(adminOption == 1) {
					serviceImpl.foodInsert();
				}
				else if(adminOption == 2){
					serviceImpl.foodUpdate();
					serviceImpl.foodInfo();
				}
				else if(adminOption == 3) {
					serviceImpl.foodDelete();
					serviceImpl.foodInfo();
				}
				else if(adminOption == 4) {
					System.out.println("FoodApp提供商品如下: ");
					serviceImpl.foodInfo();
				}
				else {
					System.out.println("選項輸入錯誤 (僅可輸入1-4) !!!");
				}
			}
			else if(userOption == 2) {
				FoodServiceImpl serviceImpl = new FoodServiceImpl();
				System.out.println("FoodApp提供商品如下: ");
				serviceImpl.foodInfo();
			}
			else {
				System.out.println("選項輸入錯誤 (僅可輸入1-2) !!!");
			}
			
		}
		catch (Exception e) {
			System.out.println("Error Message: " + e.getMessage());
		}
		
		//FoodServiceImpl serviceImpl = new FoodServiceImpl();
		//serviceImpl.foodInfo();
		//System.out.println(serviceImpl.getFoodName("牛肉麵"));
	}
}
