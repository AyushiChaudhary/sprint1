package com.capgemini.sprint.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.capgemini.sprint.bean.User;

class ControllerTest {
	Controller controller = new Controller();

	@Test
public	void  loginUserTest() {
		
		String uName = "Ayushi Chaudhary";
		String pass = "ayushi04";
		assertEquals(controller.userList.get(0),controller.loginUser(uName, pass));
	}
	@Test
 public void addToWishlistTest() {
		
	 
 }
} 