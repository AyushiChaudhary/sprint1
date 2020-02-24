package com.capgemini.sprint.main;


import java.util.Scanner;

import com.capgemini.sprint.bean.User;
import com.capgemini.sprint.controller.Controller;



public class Source {
	Scanner sc;
	Controller con;
	public static void main(String[] args) {
		System.out.println("\n\n**********Welcome to WishList Management*********** ");
		Source obj1=new Source();
		 obj1.sc=new Scanner(System.in);
	
	obj1.con=new Controller();

		 obj1.performOpr();
}
	
	public  void performOpr() {

		  System.out.println("\n Please Enter Username: ");
	      String name=sc.nextLine();
	      System.out.println("\n Please Enter Password: ");  
	      String  password = sc.nextLine();
	     User currentUser= con.loginUser(name, password);
	     if(currentUser!= null) {
	    	 userChoice(currentUser);
	     }
	     else {
	    	 performOpr();
	     }
	}

	public void userChoice(User currentUser) {
		System.out.println("\n Welcome:  "+currentUser.getUsername());
		System.out.println("\n 1. Do you want to add items to WishList \n 2. Do you want to view WishList \n 3. Logout");
		System.out.println("\n Please Enter your choice");
		int choice=sc.nextInt();
		switch(choice) {
		case 1:
			con.addItem(currentUser);
			userChoice(currentUser);
			break;
		case 2:
			con.viewWishList(currentUser.getUsername());
			userChoice(currentUser);
			break;
		case 3:
			System.exit(0);
			break;
		default:
			break;
		}
		
	}
} 