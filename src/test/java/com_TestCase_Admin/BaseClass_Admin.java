package com_TestCase_Admin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com_Utilities_Admin.ReadConfig;

public class BaseClass_Admin {
	static WebDriver driver;
	static ReadConfig read = new ReadConfig();
	static String url = read.url();

	@Parameters("browser")
	@BeforeClass
	public static void Setup(String browser) {
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers//chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		} else if (browser.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "./Drivers//IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();

		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./Drivers//geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();

		} else {
			System.out.println("Set up issue no please check");
		}
		driver.get(url);

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
