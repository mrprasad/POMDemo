package com.mrp.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ScreenLoginPF {
	
	


		//locators
		WebDriver driver;
		
		@FindBy(name="email")
		WebElement userName;
		@FindBy(name="password")
		WebElement passWord;
		@FindBy(xpath="html/body/div[2]/div[2]/form[1]/button")
		WebElement loginButton;
		
		//@FIndBy-- id,name,className,xpath,css,tagName,linkText,PartiallinkText
		
		//@FindByAll
		@FindAll({@FindBy(name="email"), @FindBy(id="username")})
		WebElement userName1;
		
		
		//methods-what we are perfoming here--actions
		
		public ScreenLoginPF(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		public void setUserName(String strUserName)
		{					
			userName.sendKeys(strUserName);
		}
		public void setPassword(String strPassword)
		{
			passWord.sendKeys(strPassword);
		}
		public void clickLoginButton()
		{
			loginButton.click();
		}
		public void logintoApp(String strUserName, String strPassword)
		{
			this.setUserName(strUserName);
			this.setPassword(strPassword);
			this.clickLoginButton();
		}
		
	}




