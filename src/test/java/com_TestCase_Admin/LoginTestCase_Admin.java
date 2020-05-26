package com_TestCase_Admin;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com_PageObject_Admin.LoginPage_PageObject;
import junit.framework.Assert;

public class LoginTestCase_Admin extends BaseClass_Admin   {
	String email=read.Email();
	String pass=read.passWord();
	String ExpectedTitle="Dashboard / nopCommerce administration";
	LoginPage_PageObject page;
	@BeforeMethod
	public void initelement() {
		page=new LoginPage_PageObject(driver);
	}
	
	@Test(priority=1)
	public void loginValidation() {
		initelement();
		page.setEmail(email);
		page.setPassword(pass);
		page.clickLogin();
		
	}
	@Test(priority=2)
	public void pageTitleValidation() {
		initelement();
		String actulTitle=driver.getTitle();
		Assert.assertEquals(ExpectedTitle,actulTitle );
		
	}
	@Test(priority=3)
	public void clickLogout() {
		page.clickLogout();
	}
	
	

}
