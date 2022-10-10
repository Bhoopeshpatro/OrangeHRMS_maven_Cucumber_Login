package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configreader
{
	private Properties prop;
	
	public Properties init_prop() 
	{
		prop = new Properties();
		try 
		{
			FileInputStream is = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(is);
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		return prop;
	}	
}
