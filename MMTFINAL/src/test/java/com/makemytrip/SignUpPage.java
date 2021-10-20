package com.makemytrip;

import java.io.IOException;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SignUpPage {
	static WebElement webelem;
	static WebDriver driver;
	
	
	
	static By loginsignupbtn = By.xpath("//li[@class='makeFlex hrtlCenter font10 makeRelative lhUser userLoggedOut']");//Login/CreateAccount
	static By loginsignUppagelabel = By.xpath("//span[@class='font26 latoBlack']");//HeaderLabel for "Login/SignUP" 
	
	static By resendotpbutton = By.xpath("//a[contains(.,'Resend OTP')]");//Resend otp Button
	static By otppagetitlelabel = By.xpath("//p[@class='font14 darkGreyText makeFlex']");//Header Label for Verify Mobile number "OTP has been sent to MOBILE/OTP has been sent to EMAIL"
	static By emaillabel =  By.xpath("//label[@class='font14 latoBold appendBottom10']");//Checking whether the Email Is written above the email input box 
	static By continuebtn = By.xpath("//button[@class='capText font16']");//continue button
	static By verifyandcreateaccbtn = By.xpath("//span[contains(.,'Verify & Create Account')]");//verifyAndCreateAccountButton

	static By backlinktext = By.xpath("//a[contains(.,'Back')]");//Resend otp Button
	static By googleapilinktext = By.xpath("//span[@class='font14 darkGreyText latoBold']/span[.='Login with Google']");//Google email link text 
	static By usernameid = By.id("username");//user input box
	static By emailalertmessg = By.xpath("//*[@id='SW']/div[1]/div[2]/div[2]/section/form/div[1]/p"); //after entering email click continue then ..
	static By enter_username = By.cssSelector("input[id='username']");//
	static By enterotplabel = By.xpath("//*[@id=\"SW\"]/div[1]/div[2]/div[2]/section/div[2]/p[1]");//Label - Enter Otp 
	static By otpinputbox= By.xpath("//input[@name='verifyOTPText']");//otpInputBox
	static By otperrormsg = By.xpath("//span[@class='validity font12 redText appendTop5 makeFlex']");//wrong otp alert element
	static By firstnamelabel = By.xpath("//p[@class='appendBottom20']");//Label- First name
	static By firstnamealertmsg = By.xpath("//*[@id=\"SW\"]/div[1]/div[2]/div[2]/section/form/div[1]/div/p");//Wrong First Name format -alert element
	static By passwordalertmsg = By.xpath("//*[@id=\"SW\"]/div[1]/div[2]/div[2]/section/form/div[2]/div/p");//Wrong Password format-alert element
	static By acccreatedtitlelabel = By.xpath("//span[@class='accountCreatedTitle']");//account created successfully label
	static By firstname = By.id("firstName");//username
	static By passid = By.id("password");//password Input Box
	static By saveandcontinuebtn = By.cssSelector("[data-cy='save'] > span");//save and Continue button

	
	
	
	
	
	
	
	public SignUpPage(WebDriver driver) {
		this.driver = driver;
	}
	public static WebElement loginSignUpBtn(WebDriver driver) {
		webelem= driver.findElement(loginsignupbtn);
		return webelem;
	}
	
	public static WebElement loginSignUpPageHeaderLabel(WebDriver driver) {
		webelem= driver.findElement(loginsignUppagelabel);
		return webelem;
	}
	
	public static WebElement resendOtpLink(WebDriver driver) {
		webelem= driver.findElement(resendotpbutton);
		return webelem;
	}
	
	public static WebElement backLinkText(WebDriver driver) {
		webelem= driver.findElement(backlinktext);
		return webelem;
	}
	public static WebElement vrfyOtpTitleLabel(WebDriver driver) {
		webelem= driver.findElement(otppagetitlelabel);
		return webelem;
	}
	public static WebElement emailLabel(WebDriver driver) {
		webelem= driver.findElement(emaillabel);
		return webelem;
	}
	public static WebElement googleEmailAPILinkText(WebDriver driver) {
		webelem= driver.findElement(googleapilinktext);
		return webelem;
	}
	public static WebElement usernameID(WebDriver driver) {
		webelem= driver.findElement(usernameid);
		return webelem;
	}
	public static WebElement continueBtn(WebDriver driver) {
		webelem= driver.findElement(continuebtn);
		return webelem;
	}
	public static WebElement emailAlertMessage(WebDriver driver) {
		webelem= driver.findElement(emailalertmessg);
		return webelem;
	}
	public static WebElement verifyAndCreateAccBtn(WebDriver driver) {
		webelem= driver.findElement(verifyandcreateaccbtn);
		return webelem;
	}
	public static WebElement otpInput(WebDriver driver) {
		webelem= driver.findElement(otpinputbox);
		return webelem;
	}
	
	public static WebElement enterOtpLabel(WebDriver driver) {
		webelem= driver.findElement(enterotplabel);
		return webelem;
	}
	public static WebElement otpErrorMessage(WebDriver driver) {
		webelem= driver.findElement(otperrormsg);
		return webelem;
	}
	public static WebElement firstNameLabel(WebDriver driver) {
		webelem= driver.findElement(firstnamelabel);
		return webelem;
	}
	public static WebElement firstNameAlertMsg(WebDriver driver) {
		webelem= driver.findElement(firstnamealertmsg);
		return webelem;
	}
	public static WebElement passwordAlertMsg(WebDriver driver) {
		webelem= driver.findElement(passwordalertmsg);
		return webelem;
	}
	public static WebElement accountCreatedMessage(WebDriver driver) {
		webelem= driver.findElement(acccreatedtitlelabel);
		return webelem;
	}
	
	public static WebElement firstName(WebDriver driver) {
		webelem= driver.findElement(firstname);
		return webelem;
	}
	public static WebElement PassID(WebDriver driver) {
		webelem= driver.findElement(passid);
		return webelem;
	}
	public static WebElement saveAndContinueBtn(WebDriver driver) {
		webelem= driver.findElement(saveandcontinuebtn);
		return webelem;
	}
	
	
	public static String otpGenerator() throws Exception {
		
		Scanner s= new Scanner(System.in);
		System.out.println("Enter the Six Digit Code");
		String otp=s.next();
		return otp;

		
	}

	
}

	
	
	
	
