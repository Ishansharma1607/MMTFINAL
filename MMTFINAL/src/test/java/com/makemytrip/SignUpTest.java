package com.makemytrip;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.baseClass.Keywords;

import net.bytebuddy.asm.Advice.Enter;

public class SignUpTest extends Keywords{
	

	//This Code used to check whether the login button is working fine or not
    @Test(enabled = false, priority = 1)
	public void verifySignUpButton() throws Exception {

		try {
			logger.info("SignUp TestCase 1: Checking Whether the Login/SignUp Button is Present in Home page or not");
			Thread.sleep(5000);

			assertTrue(SignUpPage.loginSignUpBtn(driver).isDisplayed());
			// to check if the Login/Sign-up button appears on the HomePage
			takeSnap("verifySignUpButtonPass");

		} catch (Exception e) {
			takeSnap("verifySignUpButtonFail");
			Reporter.log("FAIL");
			Assert.assertTrue(false);
		}
	}
  
  	//This code verify the sign up page
	@Test(enabled = false, priority = 2)
	public void signUpPageElementsVerification() throws Exception {
		try {
			logger.info("SignUp TestCase 2: Checking all the respective elements which is displayed in SignUp Page or not");
			driver.get(url);
			Thread.sleep(5000);
			SignUpPage.loginSignUpBtn(driver).click();
			Thread.sleep(5000);
			SignUpPage.loginSignUpBtn(driver).click();
			String s= SignUpPage.loginSignUpPageHeaderLabel(driver).getText();
			assertEquals("Login/Signup", s);
			Thread.sleep(2000);
			String t=SignUpPage.emailLabel(driver).getText();
			assertEquals("Email or Mobile Number", t);
			String u=SignUpPage.googleEmailAPILinkText(driver).getText();
			assertEquals("Login with Google", u);
			String validemail=Keywords.getCellData("src\\test\\resources\\Data1.xlsx", "InvalidData", 1, 5);
			SignUpPage.usernameID(driver).sendKeys(validemail);
			Thread.sleep(3000);
			assertTrue(SignUpPage.continueBtn(driver).isDisplayed()); // Verifying that the Verify and create account button is displayed or not
			takeSnap("signUpPageElementsVerificationPass");

		} catch (Exception e) {
			takeSnap("signUpPageElementsVerificationFail");
			Reporter.log("FAIL");
			Assert.assertTrue(false);
		}
	}
	

	
	@Test(enabled = false , priority=3)
	public void invalidEmailVerification() throws Exception {
		try {
			logger.info("SignUp TestCase 3: Checking the invalid email credentials whether it will give the alert or not");
			driver.get(url);
			Thread.sleep(6000);
			SignUpPage.loginSignUpBtn(driver).click();
			String invalidemail=Keywords.getCellData("src\\test\\resources\\Data1.xlsx", "InvalidData", 1, 0);
			System.out.println("Invalid Email Id : "+invalidemail);
			Thread.sleep(2000);
			SignUpPage.usernameID(driver).sendKeys(invalidemail);
			SignUpPage.emailLabel(driver).click(); // label email id
			implicitwait(2);
			String s = SignUpPage.emailAlertMessage(driver).getText(); // message
			assertEquals("Please enter a valid Email Id or Mobile Number.", s);
			takeSnap("invalidEmailPass");

		} catch (Exception e) {
			takeSnap("invalidEmailFail");
			Reporter.log("FAIL");
			Assert.assertTrue(false);
		}
	}
	
	@Test(enabled = false , priority = 4)
	public void blankEmailBoxVerification() throws Exception {
		try {
			logger.info("SignUp TestCase 4: Checking the Blank Email Box , Whether it holds the Place holder like 'Enter email or mobile number'");
			driver.get(url);
			Thread.sleep(5000);
			SignUpPage.loginSignUpBtn(driver).click();
			String s = SignUpPage.usernameID(driver).getAttribute("placeholder");
			assertEquals("Enter email or mobile number", s);
			Thread.sleep(4000);
			takeSnap("blankEmailPass");
			

		} catch (Exception e) {
			takeSnap("blankEmailFail");
			Reporter.log("FAIL");
			Assert.assertTrue(false);
		}
	}
	
	//This code checks if we give the phone number it redirected to phone otp verification page
	@Test(enabled = false, priority = 5)
	public void otpPageElementVerificationUsingPhoneNo() throws Exception {
		try {
			logger.info("SignUp TestCase 5: Checking the otp page elements , Whether it displays all the elements which is present in the OTP page");
			driver.get(url);
			Thread.sleep(5000);
			SignUpPage.loginSignUpBtn(driver).click();
			String validmobno=Keywords.getCellData("src\\test\\resources\\Data1.xlsx", "InvalidData", 1, 6);
			Thread.sleep(4000);
			SignUpPage.usernameID(driver).sendKeys(validmobno);
			SignUpPage.continueBtn(driver).click(); // continue button
			Thread.sleep(3000);
			String s = SignUpPage.vrfyOtpTitleLabel(driver).getText();
			assertEquals("OTP has been sent to MOBILE", s);
			assertTrue(SignUpPage.backLinkText(driver).isDisplayed());//checking the back linktext option

			Thread.sleep(3000);
			takeSnap("otpPageElementVerificationUsingPhoneNo");

		} catch (Exception e) {
			takeSnap("otpPageElementVerificationUsingPhoneNo");
			Reporter.log("FAIL");
			Assert.assertTrue(false);
		}
	}
	
	//This code is used to check whether the Verify and Create Account Page Button is displayed or not
	@Test(enabled = false , priority = 6 )
	public void verifyAndCreateAccButtonDisplay() throws Exception {
		try {
			logger.info("SignUp TestCase 6: Checking the Verify and Create Account Button Whether it is displayed or not");
			driver.get(url);
			Thread.sleep(5000);
			SignUpPage.loginSignUpBtn(driver).click();
			String validemail=Keywords.getCellData("src\\test\\resources\\Data1.xlsx", "InvalidData", 1, 5);
			SignUpPage.usernameID(driver).sendKeys(validemail);
			SignUpPage.continueBtn(driver).click();
			Thread.sleep(4000);
			String invalidotp=Keywords.getCellData("src\\test\\resources\\Data1.xlsx", "InvalidData", 1, 1);
			SignUpPage.otpInput(driver).sendKeys(invalidotp);		
			Thread.sleep(50000);
			assertTrue(SignUpPage.resendOtpLink(driver).isDisplayed());
			assertTrue(SignUpPage.verifyAndCreateAccBtn(driver).isDisplayed()); // Verifying that the Verify and create account button is displayed or not
			takeSnap("verifyandCreateAccountbuttonPass");
		}
	catch (Exception e) {
			takeSnap("verifyandCreateAccountbuttonFail");
			Reporter.log("FAIL");
			Assert.assertTrue(false);
		}
	}
	
	//This code is used to check all the elements in the OTP Page(Whether it is displayed or not)
	@Test(enabled = false, priority = 7)
	public void otpPageElementVerificationUsingEmail() throws Exception {
		try {
			logger.info("SignUp TestCase 7: Checking the OTP Page which is redirected by Using Email, and also checking the empty otp");
			driver.get(url);
			Thread.sleep(5000);
			SignUpPage.loginSignUpBtn(driver).click();
			String validemail=Keywords.getCellData("src\\test\\resources\\Data1.xlsx", "InvalidData", 1, 5);
			SignUpPage.usernameID(driver).sendKeys(validemail);
			SignUpPage.continueBtn(driver).click();
			Thread.sleep(4000);
			String m = SignUpPage.vrfyOtpTitleLabel(driver).getText();
			assertEquals("OTP has been sent to EMAIL", m);
			String s = SignUpPage.otpInput(driver).getAttribute("placeholder");
			assertEquals("Enter OTP here", s);//checking the empty otp
			Thread.sleep(5000);
			String t=SignUpPage.enterOtpLabel(driver).getText();
			assertEquals("Enter OTP", t);	//Verifying the otp page is displayed or not		
			Thread.sleep(5000);
			takeSnap("otpPageElementVerificationEmailPass");

	}
	catch (Exception e) {
			takeSnap("otpPageElementVerificationEmailFail");
			Reporter.log("FAIL");
			Assert.assertTrue(false);
		}
	}
	
	
	
	@Test(enabled = false , priority = 8)
	public void invalidOtpVerification() throws Exception {
		try {
			logger.info("SignUp TestCase 8: Checking the Invalid Otp Verification ,Whether it is giving alert like 'Incorrect OTP Entered. Please try again.' ");
			driver.get(url);
			Thread.sleep(5000);
			SignUpPage.loginSignUpBtn(driver).click();
			String validemail=Keywords.getCellData("src\\test\\resources\\Data1.xlsx", "InvalidData", 1, 5);
			SignUpPage.usernameID(driver).sendKeys(validemail);
			SignUpPage.continueBtn(driver).click();
			Thread.sleep(4000);
			String invalidotp=Keywords.getCellData("src\\test\\resources\\Data1.xlsx", "InvalidData", 1, 1);
			SignUpPage.otpInput(driver).sendKeys(invalidotp);
			SignUpPage.verifyAndCreateAccBtn(driver).click();
			String s=SignUpPage.otpErrorMessage(driver).getText();
			assertEquals("Incorrect OTP Entered. Please try again.", s);	//Verifying the otp page is displayed or not		
			Thread.sleep(2000);

		} catch (Exception e) {
			takeSnap("invalidPasswordFail");
			Reporter.log("FAIL");
			Assert.assertTrue(false);
		}
	}
	
	@Test(enabled = true, priority = 9 )
	public void invalidProfileNameandPasswordVerification() throws Exception {
		try {
				logger.info("SignUp TestCase 9: Checking the Invalid UserName and Password format,and aslo checking Whether it is giving alert or not ");
				driver.get(url);				
				
				SignUpPage.loginSignUpBtn(driver).click();
    			String validemail=Keywords.getCellData("src\\test\\resources\\Data1.xlsx", "InvalidData", 1, 5);
    			SignUpPage.usernameID(driver).sendKeys(validemail);
    			implicitwait(3);
    			SignUpPage.continueBtn(driver).click();
    			implicitwait(3);
    			String otp = SignUpPage.otpGenerator();
    			SignUpPage.otpInput(driver).sendKeys(otp);
    			SignUpPage.verifyAndCreateAccBtn(driver).click(); 
    			implicitwait(10);
    			assertTrue(SignUpPage.accountCreatedMessage(driver).isDisplayed());
    			String invalidusername=Keywords.getCellData("src\\test\\resources\\Data1.xlsx", "InvalidData", 1, 2);
    			SignUpPage.firstName(driver).sendKeys(invalidusername);
    			implicitwait(3);
    			String invalidpassword=Keywords.getCellData("src\\test\\resources\\Data1.xlsx", "InvalidData", 1, 3);
    			SignUpPage.PassID(driver).sendKeys(invalidpassword);
    			Thread.sleep(3000);
    			String s=SignUpPage.firstNameAlertMsg(driver).getText();
    			assertEquals("Please enter a valid name", s);	//Verifying the incorrect username format	
//    			String t=SignUpPage.passwordAlertMsg(driver).getText();
//    			assertEquals("Incorrect Format", t);	//Verifying the incorrect password format
//    			Thread.sleep(3000);
    			SignUpPage.firstNameLabel(driver).click();

    			Thread.sleep(10000);
    			
    			}
		catch (Exception e) {
			takeSnap("invalidEmailFail");
			Reporter.log("FAIL");
			Assert.assertTrue(false);
	}
}

	

	@Test(enabled = false, priority = 10, dataProvider = "SignUpData" )
	public void validEmail(String mail,String firstname,String pwd) throws Exception {
		try {
				logger.info("SignUp TestCase 10: Checking the valid email Credentials to register");
				driver.get(url);
				Thread.sleep(5000);
				SignUpPage.loginSignUpBtn(driver).click();
    			SignUpPage.usernameID(driver).sendKeys(mail);
    			SignUpPage.continueBtn(driver).click();
    			implicitwait(3);
    			String otp = SignUpPage.otpGenerator();
    			SignUpPage.otpInput(driver).sendKeys(otp);
    			
    			SignUpPage.verifyAndCreateAccBtn(driver).click(); 
    			SignUpPage.firstName(driver).sendKeys(firstname);
    			Thread.sleep(3000);
    			SignUpPage.PassID(driver).sendKeys(pwd);
    			Thread.sleep(3000);
    			assertTrue(SignUpPage.accountCreatedMessage(driver).isDisplayed());
    			SignUpPage.saveAndContinueBtn(driver).click();
    			Thread.sleep(60000);
    			
    			}
		catch (Exception e) {
			takeSnap("invalidEmailFail");
			Reporter.log("FAIL");
			Assert.assertTrue(false);
	}
}


	
	@DataProvider(name="SignUpData")
	String [][] getData() throws Exception
	{
		String path="src\\test\\resources\\Data1.xlsx";
		int rownum=Keywords.getRowCount(path, "SignUpdata");
		int colcount=Keywords.getCellCount(path, "SignUpdata", 1);
		String logindata[][]=new String[rownum][colcount];
		
		
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<colcount;j++) {
				logindata[i-1][j]=Keywords.getCellData(path, "SignUpdata", i, j);
			}
		}
	return logindata;
	}
	
	
	

	
	
	
}


	
