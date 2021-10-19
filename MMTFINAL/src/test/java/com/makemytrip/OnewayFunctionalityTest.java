package com.makemytrip;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.baseClass.Keywords;
import com.makemytrip.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OnewayFunctionalityTest extends Keywords {
	
	
		
		@Test
		public void loginSignupbtn() throws Exception{
		
		
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		WebDriverWait wait = new WebDriverWait(driver, 20) ;
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='autopop__wrap makeFlex column defaultCursor']")));
//		driver.findElement(By.xpath("//*[@id='SW']/div[1]/div[1]/ul/li[3]")).click();
//		driver.findElement(By.xpath("//div[@class='fsw_inputBox searchCity inactiveWidget ']")).click();
//		driver.findElement(By.xpath("//input[@class='react-autosuggest__input react-autosuggest__input--open']")).sendKeys("Mumbai");
//		
			
			driver.get(url); 
			LoginPage.Loginbtn(driver).click();
			LoginPage.UsernameID(driver).sendKeys(validemail);	
			  LoginPage.ContinueBtn(driver).click(); // continue button
			  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
				  LoginPage.PassID(driver).click(); // click inside text box
				  LoginPage.PassLbl(driver).click(); //password label
				  String s = LoginPage.EntrPassMssg(driver).getText(); // message
				  assertEquals("Please enter password.",s);

			 

		
	//	driver.quit();
	}

}
