package com.mrp.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminsManagement {
	WebDriver driver;
	
	
	@FindBy(id="")
	WebElement AddButton;
	
	public AdminsManagement(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void clickAddButton()
	{
		AddButton.click();
	}
	
	
	
	
	
	
	

}
