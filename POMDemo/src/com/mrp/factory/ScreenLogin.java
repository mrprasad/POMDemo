package com.mrp.factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ScreenLogin {

	//locators
	WebDriver driver;
	
	By userName=By.name("email");
	
	By passWord=By.name("password");
	By loginButton=By.xpath("html/body/div[2]/div[2]/form[1]/button");
	
	//methods-what we are perfoming here--actions
	
	public ScreenLogin(WebDriver driver)
	{
		this.driver=driver;
	}
	public void setUserName(String strUserName)
	{
		driver.findElement(userName).sendKeys(strUserName);
	}
	public void setPassword(String strPassword)
	{
		driver.findElement(passWord).sendKeys(strPassword);
	}
	public void clickLoginButton()
	{
		driver.findElement(loginButton).click();
	}
	public void logintoApp(String strUserName, String strPassword)
	{
		this.setUserName(strUserName);
		this.setPassword(strPassword);
		this.clickLoginButton();
	}
	
}

