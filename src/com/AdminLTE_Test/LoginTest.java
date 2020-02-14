package com.AdminLTE_Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LoginTest extends DriverLuncher {

	// public static WebDriver driver;
	Dashboard dash;

	@BeforeSuite
	public static void SetUpEnvLogin() {

		DriverLuncher.SetUpEnv();
		/// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// LoginTest loginTest = new LoginTest();

	}

	@Test(priority = 1)
	public void TestTitle() {

		String title = driver.getTitle();

		System.out.println("WebSite Title = " + title);
		
	}

	@Test(priority = 2)
	public void TestCheckTitle() {

		String acttitle = driver.getTitle();

		String exptitle = "AdminLTE 2 | Log in";

		Assert.assertEquals(acttitle, exptitle);

		System.out.println("WebSite Actual Title = " + acttitle);
		System.out.println("WebSite Expected Title = " + exptitle);
		
	}

	@Test(priority = 3)
	public void LoginLogoDisplayed() {
		WebElement loginlogo = driver.findElement(By.xpath("//div[@class='login-logo']"));
		System.out.println("Login Logo Display=" + loginlogo.isDisplayed());// true
		
	}

	@Test(priority = 4)
	public void LoginLogotext() {

		String actLogo = driver.findElement(By.xpath("//div[@class='login-logo']")).getText();
		String expLogo = "AdminLTE";
		Assert.assertEquals(actLogo, expLogo);

		System.out.println("WebSite Actual Loginlogo = " + actLogo);
		System.out.println("WebSite Expected Loginlogo = " + expLogo);
		

	}

	@Test(priority = 5)
	public void LoginBoxMsg() {

		String actLoginBoxMsg = driver.findElement(By.xpath("//p[@class='login-box-msg']")).getText();
		String expLoginBoxMsg = "Sign in to start your session";

		Assert.assertEquals(actLoginBoxMsg, expLoginBoxMsg);

		System.out.println("LoginBoxMsg Actual = " + actLoginBoxMsg);
		System.out.println("LoginBoxMsg Expected = " + expLoginBoxMsg);
		
	}

	@Test(priority = 6)
	public void EmailPlaceholderMsg() {
		String actPlaceholderMsg = driver.findElement(By.xpath("//input[@placeholder='Email']"))
				.getAttribute("placeholder");
		System.out.println("Email Placeholder:" + actPlaceholderMsg);
		
	}

	@Test(priority = 7)
	public void PasswordPlaceholderMsg() {
		String actPlaceholderMsg = driver.findElement(By.xpath("//input[@placeholder='Password']"))
				.getAttribute("placeholder");
		System.out.println("Password Placeholder:" + actPlaceholderMsg);
		
	}

	@Test(priority = 8)
	public void BlankLogin() throws InterruptedException {

		WebElement emailMainBlank = driver.findElement(By.xpath("//input[@id='email']"));
		emailMainBlank.clear();
		emailMainBlank.sendKeys("");

		WebElement passwordBlank = driver.findElement(By.xpath("//input[@id='password']"));
		passwordBlank.clear();
		passwordBlank.sendKeys("");

		Thread.sleep(2000);

		WebElement clickSignin = driver.findElement(By.xpath("//button[@type='submit']"));
		clickSignin.click();
		
	}

	@Test(priority = 9)
	public void InvalidLogin() {

		WebElement emailInvalid = driver.findElement(By.xpath("//input[@id='email']"));
		emailInvalid.clear();
		emailInvalid.sendKeys("nfhnentu");

		WebElement passwordInvalid = driver.findElement(By.xpath("//input[@id='password']"));
		passwordInvalid.clear();
		passwordInvalid.sendKeys("r34y5u");

		WebElement clickSignin = driver.findElement(By.xpath("//button[@type='submit']"));
		clickSignin.click();

	}

	@Test(priority = 10)
	public void EmailErrorMsg() {
		WebElement emailInvalid = driver.findElement(By.xpath("//input[@id='email']"));
		emailInvalid.clear();
		emailInvalid.sendKeys("nfhnentu");

		WebElement passwordInvalid = driver.findElement(By.xpath("//input[@id='password']"));
		passwordInvalid.clear();
		passwordInvalid.sendKeys("r34y5u");

		WebElement clickSignin = driver.findElement(By.xpath("//button[@type='submit']"));
		clickSignin.click();

		WebElement emailErrorMsg = driver.findElement(By.xpath("//div[@id='email_error']"));
		System.out.println("Email error Msg:" + emailErrorMsg.getText());
		
	}

	@Test(priority = 11)
	public void PasswordErrorMsg() {
		WebElement emailInvalid = driver.findElement(By.xpath("//input[@id='email']"));
		emailInvalid.clear();
		emailInvalid.sendKeys("kiran@gmail.com");

		WebElement passwordInvalid = driver.findElement(By.xpath("//input[@id='password']"));
		passwordInvalid.clear();
		passwordInvalid.sendKeys("r34y5u");

		WebElement clickSignin = driver.findElement(By.xpath("//button[@type='submit']"));
		clickSignin.click();

		WebElement pwdErrorMsg = driver.findElement(By.xpath("//div[@id='password_error']"));
		System.out.println("Password error Msg:" + pwdErrorMsg.getText());
		
	}

	@Test(priority = 12)
	public void test_Background_Color() {
		WebElement signinButton = driver.findElement(By.xpath("//button[@type='submit']"));
		System.out.println("Before mouse curser on login button,Color:" + signinButton.getCssValue("background-color"));
		Actions act = new Actions(driver);
		act.moveToElement(signinButton).build().perform();
		System.out.println("After mouse curson on login button,Color:" + signinButton.getCssValue("color"));
		
	}
	
	/*@Test(priority=13)
	public void test_check_links
	{
		
	}*/

	@Test(priority = 13)
	public void BlankEmailInvalidPassword() {

		WebElement emailMainBlank = driver.findElement(By.xpath("//input[@id='email']"));
		emailMainBlank.clear();
		emailMainBlank.sendKeys("");

		WebElement passwordInvalid = driver.findElement(By.xpath("//input[@id='password']"));
		passwordInvalid.clear();
		passwordInvalid.sendKeys("knxlnzx");

		WebElement clickSignin = driver.findElement(By.xpath("//button[@type='submit']"));
		clickSignin.click();

		WebElement emailErrorMsg = driver.findElement(By.xpath("//div[@id='email_error']"));
		System.out.println("Email error Msg:" + emailErrorMsg.getText());

		WebElement pwdErrorMsg = driver.findElement(By.xpath("//div[@id='password_error']"));
		System.out.println("Password error Msg:" + pwdErrorMsg.getText());
		
	}

	@Test(priority = 14)
	public void InvalidEmailBlankPassword() {

		WebElement emailMainBlank = driver.findElement(By.xpath("//input[@id='email']"));
		emailMainBlank.clear();
		emailMainBlank.sendKeys("dflnlzdn");

		WebElement passwordBlank = driver.findElement(By.xpath("//input[@id='password']"));
		passwordBlank.clear();
		passwordBlank.sendKeys("");

		WebElement clickSignin = driver.findElement(By.xpath("//button[@type='submit']"));
		clickSignin.click();

		WebElement emailErrorMsg = driver.findElement(By.xpath("//div[@id='email_error']"));
		System.out.println("Email error Msg:" + emailErrorMsg.getText());

		WebElement pwdErrorMsg = driver.findElement(By.xpath("//div[@id='password_error']"));
		System.out.println("Password error Msg:" + pwdErrorMsg.getText());
		
	}

	@Test(priority = 15)
	public void ValidEmailInvalidPassword() {

		WebElement validEmail = driver.findElement(By.xpath("//input[@id='email']"));
		validEmail.clear();
		validEmail.sendKeys("kiran@gmail.com");

		WebElement invalidPassword = driver.findElement(By.xpath("//input[@id='password']"));
		invalidPassword.clear();
		invalidPassword.sendKeys("sgfkgs");

		WebElement clickSignin = driver.findElement(By.xpath("//button[@type='submit']"));
		clickSignin.click();

		WebElement pwdErrorMsg = driver.findElement(By.xpath("//div[@id='password_error']"));
		System.out.println("Password error Msg:" + pwdErrorMsg.getText());
		
	}

	@Test(priority = 16)
	public void InvalidEmailValidPassword() {

		WebElement invalidEmail = driver.findElement(By.xpath("//input[@id='email']"));
		invalidEmail.clear();
		invalidEmail.sendKeys("sachin@gmail.com");

		WebElement validPassword = driver.findElement(By.xpath("//input[@id='password']"));
		validPassword.clear();
		validPassword.sendKeys("123456");

		WebElement clickSignin = driver.findElement(By.xpath("//button[@type='submit']"));
		clickSignin.click();

		WebElement emailErrorMsg = driver.findElement(By.xpath("//div[@id='email_error']"));
		System.out.println("Email error Msg:" + emailErrorMsg.getText());
		
	}

	@Test(priority = 17)
	public void testValidEmailValidPassword() {

		WebElement validEmail = driver.findElement(By.xpath("//input[@id='email']"));
		validEmail.clear();
		validEmail.sendKeys("kiran@gmail.com");

		WebElement validPassword = driver.findElement(By.xpath("//input[@id='password']"));
		validPassword.clear();
		validPassword.sendKeys("123456");

		WebElement clickSignin = driver.findElement(By.xpath("//button[@type='submit']"));
		clickSignin.click();
		
		// return new Dashboard();

	}

	// Dashboard
	@Test(priority = 18)
	public void getCurrentTitle() {
		String currenttitle = driver.getTitle();
		System.out.println("Current title=" + currenttitle);
		
	}
	
	
	@Test(priority=19)
	public void copyrightLogo()
	{
		
		String extCopyrighttext=driver.findElement(By.xpath("//footer[@class='main-footer']")).getText();
		//System.out.println(extCopyrighttext);
		String actCopyrighttext="Version 2.3.0\n" + 
				"Copyright © 2014-2015 JBK. All rights reserved.";

		Assert.assertEquals(actCopyrighttext, extCopyrighttext);
		
		System.out.println("Actual Copyrighttext:"+actCopyrighttext);
		System.out.println("Expected Copyrighttext:"+extCopyrighttext);
		
		
	}

	
	
	@Test(priority=20)
	public void CheckUserPanel()
	{
		String extUserPanaltext=driver.findElement(By.xpath("//div[@class='user-panel']")).getText();
		//System.out.println(extUserPanaltext);
		String actUserPanaltext="Kiran\n" + 
				"Online";
		Assert.assertEquals(actUserPanaltext, extUserPanaltext);
		
		System.out.println("Actual UserPanaltext:"+actUserPanaltext);
		System.out.println("Expected UserPanaltext:"+extUserPanaltext);
		
		
	}
	
	
	@Test(priority = 21)
	public void test_Background_Color_User_Registration() {
		WebElement UserRegistration = driver.findElement(By.xpath("//div[@class='small-box bg-yellow']"));
		System.out.println("Before mouse curser on UserRegistration,Color:" + UserRegistration.getCssValue("background-color"));
		Actions act = new Actions(driver);
		act.moveToElement(UserRegistration).build().perform();
		System.out.println("After mouse curson on UserRegistration,Color:" + UserRegistration.getCssValue("color"));
		
	}
	
	
	
	@Test(priority=22)
	public void test_Background_Color_New_Orders()
	{
		WebElement newOrderscolor=driver.findElement(By.xpath("//div[@class='small-box bg-aqua']"));
		Actions act= new Actions(driver);
		act.moveToElement(newOrderscolor).build().perform();
		System.out.println("Background Color of NewOrders:"+newOrderscolor.getCssValue("background-color"));
		
	}
	
	@Test(priority=23)
	public void test_Background_Color_BounceRate()
	{
		WebElement BounceRatecolor=driver.findElement(By.xpath("//div[@class='small-box bg-green']"));
		Actions act= new Actions(driver);
		act.moveToElement(BounceRatecolor).build().perform();
		System.out.println("Background Color of NewOrders:"+BounceRatecolor.getCssValue("background-color"));
		System.out.println(1);
	}
	
	@Test(priority=24,enabled=true)//if we don't want to run TestCase then make enabled=false.
	public void test_Background_Color_UniqueVisitor()
	{
		System.out.println(2);
		WebElement UniqueVisitorcolor=driver.findElement(By.xpath("//div[@class='small-box bg-red']"));
		Actions act= new Actions(driver);
		act.moveToElement(UniqueVisitorcolor).build().perform();
		System.out.println("Background Color of NewOrders:"+UniqueVisitorcolor.getCssValue("background-color"));
		
	}
	
	
	
	@Test(priority=25)
	public void test_usersButton()
	{
		WebElement usersButtonClick=driver.findElement(By.xpath("//a[@href='users.html']"));
		usersButtonClick.click();
	}
	
	@Test(priority=26)
	public void printUsersTable()
	{
		WebElement TableData=driver.findElement(By.xpath("//table[@class='table table-hover']"));
		List<WebElement> tr= TableData.findElements(By.tagName("tr"));
		for (WebElement rows : tr) {
			List<WebElement> td=rows.findElements(By.xpath("td"));
			for(WebElement cols : td)
			{
				System.out.print(" "+cols.getText());
			}
		}
	}
	
	@Test(priority=27)
	public void Chick_AddUser_Button()
	{
		WebElement addUserbutton=driver.findElement(By.xpath("//button[@class='btn btn-block btn-primary btn-sm pull-right']"));
		addUserbutton.click();
	}
	//section[@class='content-header']
	
	@Test(priority=28)
	public void check_AddUser_Lable()
	{
		String expAddUserLable=driver.findElement(By.xpath("//section[@class='content-header']")).getText();
		System.out.println(expAddUserLable);
		String actAddUserLable="Add Userv\n" + 
				"Home Add User";
		Assert.assertEquals(actAddUserLable,expAddUserLable);
		System.out.println("Actual Add Userv Lable:"+actAddUserLable);
		System.out.println("Expected Add Userv Lable:"+expAddUserLable);
	}
	
	
	@Test(priority=29)
	public void horizontal_Form_Lable()
	{
		String expHorizontalFormLable=driver.findElement(By.xpath("//h3[@class='box-title']")).getText();
		System.out.println(expHorizontalFormLable);
		String actHorizontalFormLable="Horizontal Form";
		Assert.assertEquals(actHorizontalFormLable,expHorizontalFormLable);
		System.out.println("Actual Add Userv Lable:"+actHorizontalFormLable);
		System.out.println("Expected Add Userv Lable:"+expHorizontalFormLable);
	}
	
	@Test(priority=30)
	public void Username_Placeholder()
	{
		String expUsernameHolder= driver.findElement(By.xpath("//input[@placeholder='Username']")).getAttribute("placeholder");
		String actUsernameHolder="Username";
		
		Assert.assertEquals(actUsernameHolder, expUsernameHolder);
		System.out.println("Actual Add Userv Lable:"+actUsernameHolder);
		System.out.println("Expected Add Userv Lable:"+expUsernameHolder);
		
	}

	
	@Test(priority =31)
	public void addUser_Form_Fill() {

		WebElement usernameText = driver.findElement(By.xpath("//input[@class='form-control']"));
		usernameText.clear();
		usernameText.sendKeys("Sachin Wankhade");
		
		WebElement mobileText = driver.findElement(By.xpath("//input[@placeholder='Mobile']"));
		mobileText.clear();
		mobileText.sendKeys("7030140848");
		
		WebElement emailText = driver.findElement(By.xpath("//input[@placeholder='Email']"));
		emailText.clear();
		emailText.sendKeys("sachinwankhade.it@gmail.com");
		
		WebElement genderBulletButton = driver.findElement(By.xpath("//input[@value='Male']"));
		genderBulletButton.click();
		
		WebElement selectState= driver.findElement(By.xpath("//select[@class='form-control']"));
		Select select= new Select(selectState);
		select.selectByValue("Maharashtra");
		
		
		WebElement passwordText = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		passwordText.clear();
		passwordText.sendKeys("sachin123");
	
	}
	
	
	
	
	
	
	@AfterSuite
	public void CloseEnv() {
		driver.quit();
	}

}
