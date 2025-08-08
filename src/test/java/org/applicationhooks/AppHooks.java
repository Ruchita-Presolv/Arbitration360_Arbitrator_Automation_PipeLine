package org.applicationhooks;

import java.util.Properties;

import org.factory.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.utilities.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class AppHooks {
	private WebDriver driver;
	public static Properties prop;
	@Before 
	public  void launchBrowser() {


		ConfigReader cr = new ConfigReader();
		prop =cr.init_Prop();
		DriverFactory df = new DriverFactory();
		driver = df.initdriver(prop.getProperty("Browser"));  //change 
		//System.out.println("driver"+driver);
		//System.out.println("bro "+prop.getProperty(browser));
	}
	@After (order=2)
	public void takescreenshot (Scenario scn) {
		if(scn.isFailed()) {
			String screenshotName = scn.getName().replaceAll(" ","");
			byte[] srcPath=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scn.attach(srcPath, "image/png", screenshotName);
		}
	}

	@After(order=1) public void tearDown() {
		driver.quit(); 
	}


}
