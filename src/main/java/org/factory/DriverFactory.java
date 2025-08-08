package org.factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class DriverFactory {
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	public WebDriver initdriver(String Browser) {
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("--headless=new");
		
		System.out.println("Browser value is: " + Browser);
	
		  if(Browser.equalsIgnoreCase("chrome")||Browser.contains("ch")){
		  
	
			  tlDriver.set(new ChromeDriver());
			  
	
		  }else if (Browser.equalsIgnoreCase("Edge")|| Browser.contains("Edge")){
		
		  tlDriver.set(new EdgeDriver());
		  
		  }else if (Browser.equalsIgnoreCase("ff")) {
		
		  tlDriver.set(new FirefoxDriver());
		  
		  }else{ 
			  System.out.println("Invalid Browser");
			  }
		 
	
		getDriver().manage().window().maximize();
		
		getDriver().manage().timeouts().implicitlyWait (Duration.ofSeconds(30));
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver(){
		return tlDriver.get();
	}
}




