package com.mrp.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProp {
	Properties prop;
	
	public ReadProp() throws IOException
	{
		FileInputStream file;
		try {
			file = new FileInputStream("E:\\workspace\\POMDemo\\src\\com\\mrp\\testData\\Config.properties");
			prop=new Properties();
			prop.load(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public String getData(String elementname)
	{
		String data=prop.getProperty(elementname);
		return data;
	}

}
