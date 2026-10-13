package com.WebTesting.DockerProject;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AssignmentAmazon {
	 WebDriver driver;

     @Parameters({"browser"})
	       @Test
	      public void getProduct(String browserName) throws InterruptedException, MalformedURLException {
	          
	          // Initialize browser options based on the TestNG parameter
	          if (browserName.equalsIgnoreCase("chrome")) {
	              ChromeOptions opt = new ChromeOptions();
	              opt.addArguments("--disable-dev-shm-usage");
	              opt.addArguments("--no-sandbox");
	              driver = new RemoteWebDriver(URI.create("http://localhost:4444").toURL(), opt);
	          } 
	          else if (browserName.equalsIgnoreCase("firefox")) {
	              FirefoxOptions opt = new FirefoxOptions();
	              driver = new RemoteWebDriver(URI.create("http://localhost:4444").toURL(), opt);
	          } 
	          else if (browserName.equalsIgnoreCase("edge")) {
	              EdgeOptions opt = new EdgeOptions();
	              driver = new RemoteWebDriver(URI.create("http://localhost:4444").toURL(), opt);
	          }

	          // Configure timeouts and navigate to Amazon
	          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	          driver.get("https://www.amazon.in/");
	          
	        /*  Thread.sleep(1000);
	          // Perform search action
	          WebElement searchBoxEle = driver.findElement(By.id("twotabsearchtextbox"));
	         
	          searchBoxEle.sendKeys("laptop");

	          WebElement enterEle = driver.findElement(By.id("nav-search-submit-button"));
	          enterEle.click();*/

	          System.out.println("page open successfully!");

	          // Clean up driver session after test completion
	          if (driver != null) {
	              driver.quit();
	          }
	      }
	  
  }

