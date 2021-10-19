package com.makemytrip;

import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.baseClass.Keywords;

public class LoginTest extends Keywords {

	@Test
	public void loginSignupbtn() throws Exception {

		try {
			assertTrue(LoginPage.LoginSignupbtn(driver).isDisplayed());
			// to check if the Login/Sign-up button appears on the HomePage
			takeSnap("loginSignupbtnPass");
			Assert.assertTrue(false);

		} catch (Exception e) {
			takeSnap("loginSignupbtnFail");
			Reporter.log("FAIL");
			Assert.assertTrue(false);
		}
	}

	@Test
	public void loginButton() throws Exception {
		try {
			assertTrue(LoginPage.Loginbtn(driver).isDisplayed());
		} catch (Exception e) {
			takeSnap("loginButtonFail");
			Reporter.log("FAIL");
			Assert.assertTrue(false);
		}
	}

	@Test
	public void loginPage() throws Exception {
		try {
			driver.get(url);
			LoginPage.Loginbtn(driver).click();
			assertTrue(LoginPage.Loginpagedisp(driver).isDisplayed());
			takeSnap("loginPagePass");

		} catch (Exception e) {
			takeSnap("loginPageFail");
			Reporter.log("FAIL");
			Assert.assertTrue(false);
		}
	}

	@Test
	public void invalidEmail() throws Exception {
		try {
			driver.get(url);

			// LoginPage.Loginbtn(driver).click();
			LoginPage.Loginbtn(driver).click();
			LoginPage.UsernameID(driver).sendKeys(invalidemail);
			LoginPage.EmailLabel(driver).click(); // label email id
			implicitwait(2);
			//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			String s = LoginPage.EmailMessage(driver).getText(); // message
			assertEquals("Please enter a valid Email Id or Mobile Number.", s);
			takeSnap("invalidEmailPass");

		} catch (Exception e) {
			takeSnap("invalidEmailFail");
			Reporter.log("FAIL");
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 1)
	public void blankEmail() throws Exception {
		try {
			driver.get(url);
			LoginPage.Loginbtn(driver).click();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			String s = LoginPage.EmailTextBoxMessage(driver).getAttribute("placeholder");

			assertEquals("Enter email or mobile number", s);
			takeSnap("blankEmailPass");

		} catch (Exception e) {
			takeSnap("blankEmailFail");
			Reporter.log("FAIL");
			Assert.assertTrue(false);
		}
	}

	@Test
	public void continueButtonDisplay() throws Exception {
		try {
			driver.get(url);
			LoginPage.Loginbtn(driver).click();
			LoginPage.UsernameID(driver).sendKeys(validemail);
			assertTrue(LoginPage.ContinueBtn(driver).isDisplayed()); // continue button

		} catch (Exception e) {
			takeSnap("blankEmailFail");
			Reporter.log("FAIL");
			Assert.assertTrue(false);
		}
	}

	@Test
	public void validEmailID() throws Exception {
		try {
			driver.get(url);
			LoginPage.Loginbtn(driver).click();
			LoginPage.UsernameID(driver).sendKeys(validemail);
			LoginPage.ContinueBtn(driver).click(); // continue button
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			assertTrue(LoginPage.LoginWthPassMessg(driver).isDisplayed()); // login with password message
			takeSnap("validEmailIDPass");

		} catch (Exception e) {
			takeSnap("validEmailIDFail");
			Reporter.log("FAIL");
			Assert.assertTrue(false);
		}
	}

	@SuppressWarnings("deprecation")
	@Test
	public void blankPasswordField() throws Exception {
		try {
			driver.get(url);
			LoginPage.Loginbtn(driver).click();
			LoginPage.UsernameID(driver).sendKeys(validemail);
			LoginPage.ContinueBtn(driver).click(); // continue button
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			LoginPage.PassID(driver).click(); // click inside text box
			LoginPage.PassLbl(driver).click(); // password label
			String s = LoginPage.EntrPassMssg(driver).getText(); // message
			assertEquals("Please enter password.", s);
		} catch (Exception e) {
			takeSnap("blankPasswordFieldFail");
			Reporter.log("FAIL");
			Assert.assertTrue(false);
		}
	}

	@Test
	public void invalidPassword() throws Exception {
		try {
			driver.get(url);
			LoginPage.Loginbtn(driver).click();
			LoginPage.UsernameID(driver).sendKeys(validemail);
			LoginPage.ContinueBtn(driver).click(); // continue button
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			LoginPage.PassID(driver).sendKeys(invalidpass);
			LoginPage.LgnPageBtn(driver).click();// login button
			String s = LoginPage.InccrtMsg(driver).getText(); // message xpath
			assertEquals("Either Username or Password is incorrect.", s);
			takeSnap("invalidPasswordPass");

		} catch (Exception e) {
			takeSnap("invalidPasswordFail");
			Reporter.log("FAIL");
			Assert.assertTrue(false);
		}
	}

	@Test
	public void resetPassword() throws Exception {
		try {
			driver.get(url);
			LoginPage.Loginbtn(driver).click();
			LoginPage.UsernameID(driver).sendKeys(validemail);
			LoginPage.ContinueBtn(driver).click(); // continue button
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			LoginPage.PassID(driver).sendKeys(invalidpass);
			LoginPage.LgnPageBtn(driver).click();// login button
			LoginPage.RstPassLnk(driver).click(); // reset password link
			assertTrue(LoginPage.RstPassLbl(driver).isDisplayed()); // reset password label page
			takeSnap("resetPasswordPass");

		} catch (Exception e) {
			takeSnap("resetPasswordFail");
			Reporter.log("FAIL");
			Assert.assertTrue(false);
		}
	}

	@Test
	public void validPassword() throws Exception {
		try {
			driver.get(url);
			LoginPage.Loginbtn(driver).click();
			LoginPage.UsernameID(driver).sendKeys(validemail);
			LoginPage.ContinueBtn(driver).click(); // continue button
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			LoginPage.PassID(driver).sendKeys(validpass);
			assertTrue(LoginPage.FinalLoginbtn(driver).isDisplayed());// to check if login button appears after password
																		// is entered
			LoginPage.LgnPageBtn(driver).click(); // login button
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			String s = driver.getTitle();
			assertEquals("MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday", s);
		} catch (Exception e) {
			takeSnap("validPasswordFail");
			Reporter.log("FAIL");
			Assert.assertTrue(false);
		}
	}

	@Test
	public void validMobileNumber() throws Exception {
		try {
			driver.get(url);
			LoginPage.Loginbtn(driver).click();
			LoginPage.UsernameID(driver).sendKeys(validmobno);
			LoginPage.ContinueBtn(driver).click(); // continue button
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			assertTrue(LoginPage.VrfyMobNo(driver).isDisplayed()); // verify mobile number page
		} catch (Exception e) {
			takeSnap("validMobileNumberFail");
			Reporter.log("FAIL");
			Assert.assertTrue(false);
		}
	}

	@Test
	public void invalidMobileNumber() throws Exception {
		try {
			driver.get(url);
			LoginPage.Loginbtn(driver).click();
			LoginPage.UsernameID(driver).sendKeys(invalidmobno);
			LoginPage.ContinueBtn(driver).click(); // continue button
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			assertTrue(LoginPage.errorMsg(driver).isDisplayed()); // number not registered message
			takeSnap("invalidMobileNumberPass");

		} catch (Exception e) {
			takeSnap("invalidMobileNumberFail");
			Reporter.log("FAIL");
			Assert.assertTrue(false);
		}
	}

	@Test
	public void mimimumCharMessage() throws Exception {
		try {
			driver.get(url);
			LoginPage.Loginbtn(driver).click();
			LoginPage.UsernameID(driver).sendKeys(validemail);
			LoginPage.ContinueBtn(driver).click(); // continue button
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			String s = LoginPage.MinCharPassMssg(driver).getAttribute("placeholder");
			assertEquals("Minimum 6 characters.", s);
			takeSnap("mimimumCharMessagePass");

		} catch (Exception e) {
			takeSnap("mimimumCharMessageFail");
			Reporter.log("FAIL");
			Assert.assertTrue(false);
		}
	}
}