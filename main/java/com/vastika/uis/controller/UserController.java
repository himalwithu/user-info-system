package com.vastika.uis.controller;

import java.util.List;

import javax.swing.JOptionPane;

import com.vastika.uis.model.User;
import com.vastika.uis.service.UserService;
import com.vastika.uis.service.UserServiceImpl;

public class UserController {

	public static void main(String[] args) {
		UserService userService = new UserServiceImpl(); 
		String decision = "";
	   do {
		   String choice = JOptionPane.showInputDialog("Enter choice: save|update|delete|list|get");
			
			switch (choice) {
			case "save":
				User user = getUser();
				int saved = userService.saveUserInfo(user);
				if(saved>=1) {
					JOptionPane.showInternalMessageDialog(null,  "User infor is saved successfully in db.");
				}else {
					JOptionPane.showInternalMessageDialog(null,  "Error in db.");
				}
				
				break;
				
			case "update":
				User deletedUser = getUser();
				
				int id = Integer.parseInt(JOptionPane.showInputDialog("Enter id:"));
				deletedUser.setId(id);
				int updated = userService.updateUserInfo(deletedUser);
				if(updated>=1) {
					JOptionPane.showInternalMessageDialog(null,  "User info is updated successfully in db.");
				}else {
					JOptionPane.showInternalMessageDialog(null,  "Error in db.");
				}
				break;
		
				
			
				
			case "delete":
			 id = Integer.parseInt(JOptionPane.showInputDialog("Enter id:"));
			
				int deleted = userService.deleteUserInfo(id);
				if(deleted>=1) {
					JOptionPane.showInternalMessageDialog(null,  "User info is deleted successfully.");
				}else {
					JOptionPane.showInternalMessageDialog(null,  "Error in db.");
				}
				break;
				
			
					
			
			
			case "list":
				List<User> userList = userService.getAllUserInfo();
				for (User u: userList) {
					System.out.println("User id is: "+u.getId());
					System.out.println("User name is: "+u.getUsername());
					System.out.println("User password is: "+u.getPassword());
					System.out.println("User id Mobile no is: "+u.getMobileNo());
					System.out.println("User Salary is: "+u.getSalary());
					System.out.println("Is user active? : "+u.isActive());
					System.out.println("=======================");
				}
			
	break;
			
		
		
		case "get":
			id = Integer.parseInt(JOptionPane.showInputDialog("Enter id: "));
			User u = userService.getUserById(id);
			
				System.out.println("User id is: "+u.getId());
				System.out.println("User name is: "+u.getUsername());
				System.out.println("User password is: "+u.getPassword());
				System.out.println("User id Mobile no is: "+u.getMobileNo());
				System.out.println("User Salary is: "+u.getSalary());
				System.out.println("Is user active? : "+u.isActive());
				
			
			break;
					
				default:
					JOptionPane.showInternalMessageDialog(null, "wrong choice");

				break;	
			}
			
			decision = JOptionPane.showInputDialog("do you want to perform next operation? Enter Yes|No" );
		   
	   }while(decision.equalsIgnoreCase("yes"));
	   
	JOptionPane.showInternalMessageDialog(null, "Bye Bye!! Happy Coding...See you.");
		}
	
	public static User getUser() {
		User user = new User();
		String username = JOptionPane.showInputDialog("Enter username: ");
		String password = JOptionPane.showInputDialog("Enter password: ");
		long mobileNo = Long.parseLong (JOptionPane.showInputDialog("Enter mobile no: "));
		double salary = Double.parseDouble(JOptionPane.showInputDialog("Enter salary: "));
		boolean isActive = Boolean.parseBoolean(JOptionPane.showInputDialog("Enter is user active?: "));
        user.setUsername(username);
		user.setPassword(password);
		user.setMobileNo(mobileNo);
		user.setActive(isActive);
		user.setSalary(salary);
		
		return user;
	}
	
}
	

