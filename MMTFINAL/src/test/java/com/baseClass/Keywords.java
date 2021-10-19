package com.baseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Keywords {

	public WebDriver driver;
	String browser;
	String read;

	public String url;
	
	// login
	public String invalidemail;
	public String validemail;
	public String invalidpass;
	public String validpass;
	public String validmobno;
	public String invalidmobno;

	// flights

	public String firstname;
	public String lastname;
	public String mobileno;
	public String emailid;
	public String furl;

	// registration
	static String regEmail;
	static String regMobile;
	static String newEmail;
	static String newMobile;
	static String newEmailPass;
	static String newMobPass;
	static String newMobName;
	static String newEmailName;

	

	public void getUrl(String url) {
		driver.get(url);

	}

	public void implicitwait(int timeinseconds) {
		driver.manage().timeouts().implicitlyWait(timeinseconds, TimeUnit.SECONDS);
	}

	public void takeSnap(String filename) throws IOException {

		TakesScreenshot screenshot = ((TakesScreenshot) driver);
		File srcfile = screenshot.getScreenshotAs(OutputType.FILE);
		 File file= new File("ScreenShots\\" + filename + ".png");
		 String path = "ScreenShots\\" + filename + ".png";
		try {
			FileUtils.copyFile(srcfile, file);
			 Reporter.log(path); 
			
		} catch (Exception E) {
			System.out.println("Error with taking ScreenShot");
		}

	}

	public String readproperty(String data) throws IOException {
		String READ;
		FileInputStream fis = new FileInputStream("src\\test\\resources\\config.properties");
		Properties prop = new Properties();
		prop.load(fis);
		READ = prop.getProperty(data);
		fis.close();
		return READ;

	}

	public String readlocator(String data) throws IOException {
		String READ;
		FileInputStream fis = new FileInputStream("src\\test\\resources\\locator.properties");
		Properties prop = new Properties();
		prop.load(fis);
		READ = prop.getProperty(data);
		fis.close();
		return READ;

	}

	@BeforeTest
	public void setup() throws Exception {

		FileInputStream finput = new FileInputStream("src\\test\\resources\\config.properties");
		Properties prop = new Properties();
		prop.load(finput);

		browser = prop.getProperty("browser");
		url = prop.getProperty("URL");

		// login
		invalidemail = prop.getProperty("InvalidEmail");
		validemail = prop.getProperty("ValidEmail");
		invalidpass = prop.getProperty("InvalidPassword");
		validpass = prop.getProperty("ValidPassword");
		validmobno = prop.getProperty("ValidMobileNo");
		invalidmobno = prop.getProperty("InvalidMobNo");

		// flight
		firstname = prop.getProperty("fristname");
		lastname = prop.getProperty("lastname");
		mobileno = prop.getProperty("mobileno");
		emailid = prop.getProperty("emailid");

		furl = prop.getProperty("URL");
		firstname = prop.getProperty("firstname");

		// registration
		regEmail = prop.getProperty("regisEmail");
		regMobile = prop.getProperty("regisMob");
		newEmail = prop.getProperty("newEmail");
		newMobile = prop.getProperty("newMob");
		newEmailPass = prop.getProperty("newEmailPass");
		newMobName = prop.getProperty("newMobName");
		newMobPass = prop.getProperty("newMobPass");
		newEmailName = prop.getProperty("newEmailName");

		Reporter.log("Setting up " + browser + " with" + url);

		finput.close();

		switch (browser) {
		case "firefox":

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		}

		driver.get(url);
		driver.manage().window().maximize();
	}

	@AfterTest
	public void afterMethod() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
