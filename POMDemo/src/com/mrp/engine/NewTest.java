package com.mrp.engine;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.mrp.factory.ScreenAdminDetails;
import com.mrp.pageFactory.ScreenLoginPF;
import com.mrp.utility.ExcelUtils;
import com.mrp.utility.ReadProp;

public class NewTest {
	
	//TC is work as a engine
	public static WebDriver driver;
	public static String Url="";
	public static String Username="";
	public static String Password="";
	public static int rowcount;
	
	
	ScreenLoginPF objScreenLoginpf;
	ScreenAdminDetails objScreenAdminDetails;
	ReadProp objReadProp;
	ExcelUtils objExcelUtils;
	
	
	
	 @BeforeTest
	  public void beforeTest() throws Exception  {
		 driver=new FirefoxDriver();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//System.out.println("url"+Url);
		//objExcelUtils.setExcelFile("C:\\Users\\OMG\\Desktop\\Selenium.xlsx");
		objExcelUtils.setExcelFile("C:\\Users\\OMG\\Desktop\\Selenium.xlsx");
		ReadProp objReadProp=new ReadProp();
		Url=objReadProp.getData("PRODURL");
		//Username=objReadProp.getData("UserName");
		//Password=objReadProp.getData("PassWord");
		
		rowcount=objExcelUtils.getRowCount("MyClass");
		
		System.out.println("rowcont"+rowcount);
		
		
		
	  }
	 
	 
  @Test
  public void testLoginPage() throws Exception {
		  ScreenLoginPF objScreenLoginpf= new ScreenLoginPF(driver);
		  for(int i=1;i<=rowcount;i++)
			{
				
			Username=ExcelUtils.getCellData(i, 0, "MyClass");
			System.out.println(Username);
			
			Password=ExcelUtils.getCellData(i, 1, "MyClass");
			System.out.println(Password);
			driver.get(Url);
			objScreenLoginpf.logintoApp(Username, Password);
			
			}
	  
	  
  }
   

  @AfterTest
  public void afterTest() {
	  driver.close();
  }
  

}
