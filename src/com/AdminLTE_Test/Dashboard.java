package com.AdminLTE_Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Dashboard extends DriverLuncher {
	
	@BeforeMethod
	public static void SetUpEnvDashboard() {
		
		DriverLuncher.SetUpEnv();
		LoginTest loginTest= new LoginTest();
		//Dashboard dashboard=loginTest.testValidEmailValidPassword();
		
		
	}

	
	@AfterMethod
	public void CloseBrowser()
	{
		driver.quit();
	}
}
