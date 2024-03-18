package org.tcs.selenium.LanuchBrower.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class PropertiesLoad {
	
	public  String WorkingDirectory = System.getProperty("user.dir");
	public static HashMap<String,String> properties = new HashMap<String,String>();
	
	public  String getCurrentWorkingDir() {
		return WorkingDirectory;
	}
	
	
	public HashMap<String,String> loadProperties(String PropertyName) {
		PropertiesLoad propLoad 					 =  new PropertiesLoad();	
		Properties prop		 					     =	new Properties();
		try {
			String dir								 =	propLoad.getCurrentWorkingDir();
			File file								 =	new File(dir+File.separator+"Properties"+File.separator+PropertyName+".properties");
			FileInputStream fis						 =	new FileInputStream(file);
			prop.load(fis);
			
			Set set = prop.entrySet();
			Iterator itr = set.iterator();
			
			while(itr.hasNext()) {
				Map.Entry entry=(Map.Entry)itr.next(); 
				properties.put((String)entry.getKey(), (String)entry.getValue());
			}
			System.out.println("Properties are loaded propertly...");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Unable to read properties");
		}
		return properties;
	}
}
