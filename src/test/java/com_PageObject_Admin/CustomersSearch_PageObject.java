package com_PageObject_Admin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com_Utilities_Admin.WaitHelper;

public class CustomersSearch_PageObject {

	WebDriver driver;
	WaitHelper helper;

	public CustomersSearch_PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		helper = new WaitHelper(driver);
	}

	@FindBy(linkText = "Customers")
	WebElement customerMenu;

	@FindBy(xpath = "//*[@class='menu-item-title' and text()='Customers']")
	WebElement customerMenuItem;

	@FindBy(id = "SearchEmail")
	WebElement emailbox;

	@FindBy(id = "SearchFirstName")
	WebElement firstname;

	@FindBy(id = "SearchLastName")
	WebElement lastname;
	@FindBy(id = "search-customers")
	WebElement searchButton;

	@FindBy(xpath = "//*[@id=\"customers-grid_wrapper\"]//tbody")
	WebElement table;
	@FindBy(xpath = "//*[@id=\"customers-grid_wrapper\"]//tbody/tr")
	List<WebElement> TableRows;
	@FindBy(xpath = "//*[@id=\"customers-grid_wrapper\"]//tbody/tr/td")
	List<WebElement> TableColumn;

	public void clickCustomer() {
		customerMenu.click();
	}

	public void clickCustomerMenu() {
		customerMenuItem.click();
	}

	public void setmail(String mail) {
		helper.waitForElement(emailbox, 30);
		emailbox.clear();
		emailbox.sendKeys(mail);

	}

	public void setFirstName(String first) {
		helper.waitForElement(firstname, 30);
		firstname.clear();
		firstname.sendKeys(first);
	}

	public void setLastName(String last) {
		helper.waitForElement(lastname, 30);
		lastname.clear();
		lastname.sendKeys(last);

	}

	public void clickSearch() {
		searchButton.click();
	}

	public int getRowCount() {
		return TableRows.size();
	}

	public int getColumnCount() {
		return TableColumn.size();
	}

	public boolean searchBymail(String mail) {
		boolean status = false;
		for (int i = 0; i <= getRowCount(); i++) {
	String email = driver.findElement(By.xpath("//*[@id=\"customers-grid\"]/tbody/tr/td[2]")).getText();
					
			if (email.equals(mail)) {
				status = true;
			}
		}
		return status;
	}

	public boolean searchByname() {
		boolean status = false;
		for (int j = 0; j <= getRowCount(); j++) {
	String custName = driver.findElement(By.xpath("//*[@id=\"customers-grid\"]/tbody/tr/td[3]")).getText();
					
			String[] ar = custName.split(" ");
			if (ar[0].equals("Victoria") && ar[1].equals("Terces")) {
				status = true;

			}

		}
		return status;

	}

}
