package com_Utilities_Admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	  Properties prop;

	public ReadConfig() {
		try {
			prop = new Properties();
			File file = new File("./Configuration//Config.properties");
			FileInputStream input = new FileInputStream(file);
			prop.load(input);
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}

	public String url() {
		String url = prop.getProperty("url");
		return url;
	}

	public String Email() {
		String email = prop.getProperty("Email");
		return email;
	}

	public String passWord() {
		String password = prop.getProperty("Password");
		return password;
	}

}
