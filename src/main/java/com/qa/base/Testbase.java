/**
 * 
 */
package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Jagadeeshwar
 *
 */
public class Testbase {
	public int Response_Status_Code_200 = 200;
	public Properties prop;
	public FileInputStream file;

	public Testbase() {

		try {
			prop = new Properties();
			file = new FileInputStream(
					System.getProperty("user.dir") + "//src//main//java//com//qa//config//config.properties");
			prop.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
