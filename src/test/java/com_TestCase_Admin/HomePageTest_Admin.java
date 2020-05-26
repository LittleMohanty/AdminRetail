package com_TestCase_Admin;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com_PageObject_Admin.HomePage_PageObject;

public class HomePageTest_Admin extends BaseClass_Admin {
	LoginTestCase_Admin login = new LoginTestCase_Admin();
	HomePage_PageObject home;
	SoftAssert soft1=new SoftAssert();
	String expected="Dashboard";

	@Test(priority = 1)
	public void loginTest() {
		login.loginValidation();
	}
 
	public void homeInitialise() {
	  home=new HomePage_PageObject(driver);
	  
	}
	@Test(priority=2)
	public void buttonPresentValidation() {
		homeInitialise();
		soft1.assertEquals(expected, home.dashBoardIspresent());
		soft1.assertTrue(home.logoIspresent());
		soft1.assertTrue(home.logoutIsdisplay());
		soft1.assertTrue(home.elementDisplayValidation());
		soft1.assertAll();
	}
}
