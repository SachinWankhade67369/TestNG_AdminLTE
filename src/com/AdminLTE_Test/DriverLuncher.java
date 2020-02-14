package com.AdminLTE_Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class DriverLuncher {
	    public static WebDriver driver;
	    public static EventFiringWebDriver event_Driver;


	public static void SetUpEnv() {
		/*driver = new FirefoxDriver();
		driver.get("file:///G:/JAVA%20Material/Offline%20Website/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait-(20, TimeUnit.SECONDS);
*/

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("file:///G:/JAVA%20Material/Offline%20Website/index.html");
		
		//to launch web event listener.
		event_Driver= new EventFiringWebDriver(driver);
		WebElementListner webEleListner= new WebElementListner();
		event_Driver.register(webEleListner);
		driver=event_Driver;
		
	}
	
	public void failed(String method_name) throws IOException
	{
		File scr= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scr, new File("D:/SeleniumFailerScreenshot/"+method_name+".jpg"));
		
	}

}
