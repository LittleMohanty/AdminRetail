package com_TestCase_Admin;

import org.testng.Assert;
import org.testng.annotations.Test;

import com_PageObject_Admin.CustomersSearch_PageObject;

public class CustomerSearchTest extends BaseClass_Admin {
	LoginTestCase_Admin login=new LoginTestCase_Admin();
	CustomersSearch_PageObject cust;
	String email="victoria_victoria@nopCommerce.com";
	String first="Victoria";
	String last="Terces";
	public void initElement() {
		cust=new CustomersSearch_PageObject(driver);
	}
	@Test(priority=1)
	public void customerPageValidation() {
		login.loginValidation();
		initElement();
		cust.clickCustomer();
		cust.clickCustomerMenu();
	}
	@Test(priority=2)
	public void searchByemailValidation() throws InterruptedException {
		initElement();
		cust.setmail(email);
		cust.clickSearch();
	    Thread.sleep(3000);
		Assert.assertTrue(cust.searchBymail(email));
}
	@Test(priority=3)
	public void  searchByName() throws InterruptedException {
		initElement();
		cust.setFirstName(first);
		cust.setLastName("Terces");
		cust.clickSearch();
		Thread.sleep(3000);
		Assert.assertTrue(cust.searchByname());
		
	}
}
