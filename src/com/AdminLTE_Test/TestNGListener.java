package com.AdminLTE_Test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener extends LoginTest implements ITestListener{
	@Override
	public void onFinish(ITestContext arg0) {
		System.out.println("onFinish");
		System.out.println("---------------------------------");
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		System.out.println("onStart");
		System.out.println("---------------------------------");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		System.out.println("onTestFailedButWithinSuccessPercentage");
		System.out.println("---------------------------------");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure");
		System.out.println("---------------------------------");
		
		//File scr= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
		//	FileUtils.copyFile(scr, new File("D:/Selenium/"+System.currentTimeMillis()+".jpg"));
			failed(result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		System.out.println("onTestSkipped");
		System.out.println("---------------------------------");
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		System.out.println("onTestStart");
		
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		System.out.println("onTestSuccess");
		System.out.println("-------------------");
		
	}
}
