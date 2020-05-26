package com_PageObject_Admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_PageObject {

	 WebDriver driver;
public LoginPage_PageObject(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);	
}
@FindBy(id="Email")
WebElement email;

@FindBy(id="Password")
WebElement password;
@FindBy(xpath="//input[@type='submit']")
WebElement login;
@FindBy(linkText="Logout")
WebElement logout;


public void setEmail(String mail) {
	email.clear();
	email.sendKeys(mail);
}
public void setPassword(String pass) {
	password.clear();
	password.sendKeys(pass);
	
}
public void clickLogin() {
	login.click();
}
public void clickLogout() {
	logout.click();
}


}
