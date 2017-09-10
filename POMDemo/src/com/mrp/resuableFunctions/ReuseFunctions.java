package com.mrp.resuableFunctions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ReuseFunctions {
	//reusable functions
	
	WebDriver driver;
	
	public ReuseFunctions(WebDriver driver)
	{
		this.driver=driver;
	}

	
	public void takeScreenshot(String filepath) throws IOException
	{
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(src, new File(filepath));
	}
	
	public void mouserOver(WebElement mainlink,WebElement sublink)
	
	{
		Actions acti=new Actions(driver);
		acti.moveToElement(mainlink).moveToElement(sublink).click().build().perform();
		
	}
}
