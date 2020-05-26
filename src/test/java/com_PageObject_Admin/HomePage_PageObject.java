package com_PageObject_Admin;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage_PageObject {
	WebDriver driver;

	public HomePage_PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='content-header']")
	WebElement DashBoard;
	@FindBy(xpath = "//a[@class='logo']")
	WebElement logo;
	@FindBy(linkText = "Logout")
	WebElement logout;
	@FindBy(xpath = "//*[@class='box-title']")
	List<WebElement> element;

	public String dashBoardIspresent() {
		String dash = DashBoard.getText();
		return dash;

	}

	public boolean logoIspresent() {
		boolean result = logo.isDisplayed();
		return result;
	}
	public boolean logoutIsdisplay() {
		return logout.isDisplayed();
		
	}
	public boolean elementDisplayValidation() {
	  for(WebElement el:element) {
		  el.isDisplayed();
	  }
	return true;
	   
	}

}
