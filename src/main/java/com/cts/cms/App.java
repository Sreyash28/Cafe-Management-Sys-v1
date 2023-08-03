package com.cts.cms;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cts.cms.exceptions.SystemException;
import com.cts.cms.model.User;
import com.cts.cms.service.MenuItemsService;
import com.cts.cms.service.OrderItemsService;
import com.cts.cms.service.OrdersService;
import com.cts.cms.service.UserService;

/**
 * Hello world!
 *
 */

public class App {
	public static void main(String[] args) throws SystemException {
		ApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");
		UserService userService = (UserService) context.getBean("userService");
		MenuItemsService items = (MenuItemsService) context.getBean("menuitemsService");
		OrdersService orders = (OrdersService) context.getBean("ordersService");
		OrderItemsService orderItems = (OrderItemsService) context.getBean("orderItemsService");

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("\n1. For Add User");
			System.out.println("2. For Login the User");
			System.out.println("3. For User List");
			System.out.println("4. For user Id");
			System.out.println("5. For Menu Items");
			System.out.println("6. For Search MenuItem by ID");
			System.out.println("7. For All Orders");
			System.out.println("8. For Search Order");
			System.out.println("9. For total bill");
			System.out.println("10. For Search a orderItem");
			System.out.println("11. For Exit\n");
			System.out.println("Enter your choice:");

			int ch = Integer.parseInt(sc.nextLine());

			switch (ch) {
			case 1:
				System.out.println("Enter User Id: ");
				int id = Integer.parseInt(sc.nextLine());

				System.out.println("Enter User Name: ");
				String userName = sc.nextLine();

				System.out.println("Enter Contact Number: ");
				String contactNumber = sc.nextLine();

				System.out.println("Enter Email: ");
				String email = sc.nextLine();

				System.out.println("Enter Password: ");
				String password = sc.nextLine();

				System.out.println("Enter Role: ");
				String role = sc.nextLine();

				User user = new User(id, userName, contactNumber, email, password, role);
				userService.createUser(user);
				break;
			case 2:
				System.out.println("Login");
				System.out.println("Enter email:");
				String name = sc.nextLine();
				System.out.println("Enter password:");
				String pass = sc.nextLine();
				int users = userService.loginUser(name, pass);
				if (users > 0) {
					System.out.println("Login successful..!");
					System.out.println("Welcome " + name);
				} else {
					System.out.println("Login failed");
				}
				break;

			case 3:
				System.out.println("Usesr List:");
				userService.getAllUser().forEach(System.out::println);
				break;
			case 4:
				System.out.println("Ener User Id to be searched");
				int Id = Integer.parseInt(sc.nextLine());
				try {
					System.out.println(userService.getUserById(Id));

				} catch (SystemException e) {
					System.err.println(e.getMessage());
				}
				break;
			case 5:
				System.out.println("\nResult For Menu_Items:\n");
				items.getAllItems().forEach(System.out::println);
				break;
			case 6:
				System.out.println("\nEner MenuItem Id want to be searched");
				int mId = Integer.parseInt(sc.nextLine());
				try {
					System.out.println(items.getItemById(mId));

				} catch (SystemException e) {
					System.err.println(e.getMessage());
				}
				break;

			case 7:
				System.out.println("Orders:");
				orders.getAllOrders().forEach(System.out::println);
				break;
			case 8:
				System.out.println("Enter Order Id want to be searched");
				int OrderId = Integer.parseInt(sc.nextLine());
				try {
					System.out.println(orders.getOrdersById(OrderId));

				} catch (SystemException e) {
					System.err.println(e.getMessage());
				}
				break;
			case 9:
				System.out.println("For Bill Total");
//
				System.out.println("Enter Quantity: ");
				int quantity = Integer.parseInt(sc.nextLine());
//
				System.out.println("Enter Price: ");
				double price = Double.parseDouble(sc.nextLine());

//				try {
				double total = orderItems.calculateTotal(quantity, price);
				System.out.println("Total Bill Amount: " + total);
//				} catch (SystemException e) {
//					System.out.println("Error occurred while calculating total: " + e.getMessage());
//				}
				break;

			case 10:
				System.out.println("Enter Order_Item Id want to be searched");
				int OrderItemId = Integer.parseInt(sc.nextLine());
				try {
					System.out.println(orderItems.getOrderItemById(OrderItemId));

				} catch (SystemException e) {
					System.err.println(e.getMessage());
				}
				break;
			case 11:
				System.exit(1);
			}

		}

	}
}
