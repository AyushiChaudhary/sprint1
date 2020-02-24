package com.capgemini.sprint.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.capgemini.sprint.bean.Items;
import com.capgemini.sprint.bean.User;

public class Controller {
	List<Items> itemList= new ArrayList<>();// list having details of items
	List<User> userList= new ArrayList<>(); // list having details of users
	 HashMap<String,List<Items>> wishList=new HashMap<>();
	 List<Items> list = new ArrayList<>();
	
	public Controller() {
		super();
		setItems();
		setUser();
	}

	
	public void setItems() {
		itemList.add(new Items("Cooler",1,100.0));
		itemList.add(new Items("Fan",2,1000.0));
		itemList.add( new Items("Tv",3,2000.0));
		itemList.add( new Items("Ac",4,5000.0));
		itemList.add( new Items("Fridge",5,10000.0));
		itemList.add( new Items("Mobile",6,50000.0));
		itemList.add( new Items("Pencil",7,50.0));
		itemList.add( new Items("Book",8,300.0));
		itemList.add( new Items("Pen",9,8000.0));
		itemList.add( new Items("Table",10,7000.0));
		itemList.add( new Items("Chair",11,3000.0));
		itemList.add( new Items("Bed",12,50008.0));
		itemList.add( new Items("Sofa",13,50000.0));
	}
	
		
	
	public void setUser() {
		userList.add( new User("Ayushi Chaudhary", "ayushi04"));
		userList.add(new User("Ashish Sharma", "ayuashi"));
		userList.add( new User("Garima Verma", "garima89"));
		userList.add( new User("Ayushi Dubey", "dubeyji"));
		userList.add( new User("Reetesh golu", "golu"));
	
		
	}
	public void getUser() {
		
	}
	
	public User  loginUser(String uName,String pass) {
	
	      User loginUser= null;
	      boolean flag = false;
	      for (User u:userList)
	      {
	    	  if(u.getUsername().equals(uName) && u.getPassword().equals(pass)) {
	    		  flag=  true;
	    		  loginUser=u;
	    		  break;
	    	  }
	    		 
	      }
	      if(flag) {
	    	  return loginUser;
	    }
	    	  else 
	    	  {
	    		  System.out.println("Invalid Credentials");	
	    		  return null;
	    	  }
	      }
	
	 @SuppressWarnings("resource")
	public void addItem(User loginuser) {

		 boolean flag = false;
		Scanner scan=new Scanner(System.in);	
		 Items currentItem = null;
		 itemList.stream().forEach(e->System.out.println(" * " + e.getName()));
	       
	    	   
	    	   System.out.println("please enter item you want to wishlist :");
		         String a1 = scan.nextLine();
			     for(Items i:itemList) {
			    	   if(i.getName().equals(a1))
		               {
		               
		               	currentItem=i;
		               	break;
		               }      	
			     }
			   
			     if(currentItem!=null) {
			    	 
				     
					   addToWishlist(currentItem,loginuser);
					    	 	    
					    
			     }
				
			    else {
			    	System.out.println("Item not available");
			  
			    }
	       
	}
	 public void addToWishlist(Items currentItem, User loginuser) {
		    
		 boolean flag=false;
		 if(list.isEmpty()) {
			 list.add(currentItem);
		 }
		 else {
			 for(Items i:list) {
				 if(i.getName().equals(currentItem.getName())) {
					 flag=true;
					 break;
				 }
			 }
			 if(flag) {
				 System.out.println("Item already added in wishlist");
				 
			 }
			 else {
				 list.add(currentItem);
			 }
		 }
		   
		    if(wishList.isEmpty()) {
		    	 wishList.put(loginuser.getUsername(), list);
		    	 System.out.println("\n Item added to wishlist!");
		    	
		    }
		    else {
		    	wishList.replace(loginuser.getUsername(), list);
		    	 System.out.println("\n Item added to wishlist!");
		    }
		    
	        
		}
			
		public void viewWishList(String username) {
			if(!(wishList.isEmpty())) {
			List<Items> list=wishList.get(username);
			System.out.println("\n\n Welcome: "+username);
			System.out.println("Name\t Price\t");
			for(Items i:list) {
				System.out.println(i.getName()+"\t"+i.getPrice()+"\t");
			}
		}
			else {
				System.out.println("\n Wishlist is empty!");
			}
	
		
		
		}
	}