package com.mrp.pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPF {
	
	WebDriver driver;
	
	@FindBy(name="")
	WebElement AccountMainLink;
	@FindBy(name="")
	WebElement AdminLink;
	/*driver.findElement(By.name("fname")).sendKeys("test1");
	driver.findElement(By.name("lname")).sendKeys("test1");
	driver.findElement(By.name("email")).sendKeys("test1@gmail.com");
	driver.findElement(By.name("password")).sendKeys("abcdef");
	driver.findElement(By.name("mobile")).sendKeys("9123456789");
	driver.findElement(By.name("address1")).sendKeys("Add1");
	driver.findElement(By.name("address2")).sendKeys("Add2");
	driver.findElement(By.xpath("//*[@id='s2id_autogen1']/a")).click();
	driver.findElement(By.xpath("//*[@id='select2-drop']/ul/li[5]")).click();*/
	
	public DashboardPF(WebDriver driver)
	{
		this.driver=driver;
	}
	public void clickAccountMain()
	{
		AccountMainLink.click();
	}
	public void clickAdminsubAccount()
	{
		AdminLink.click();
	}
	

}
