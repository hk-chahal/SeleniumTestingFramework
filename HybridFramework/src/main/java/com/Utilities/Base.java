package com.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class Base {
	public static WebDriver webDriver = null;
	public static EventFiringWebDriver driver;
	
	
	public static Properties config = new Properties(); 
	 
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\com\\testdata\\testdata.xlsx");
	
	
	public ExtentReports extentreport = ExtentManager.getInstance();
	public static ExtentTest report;
	public static String browser;

	
	public static EventFiringWebDriver  getDriver() {
		driver = new EventFiringWebDriver(webDriver);

		MyListener myListener = new MyListener();
		driver.register(myListener);

		return driver;

	}
	
	@BeforeTest(alwaysRun=true)
	public static void loadPropertiesFile() throws IOException {
		InputStream property = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\Properties\\Config.properties");
		config.load(property);
		browser = config.getProperty("browser");
	}
	
	
	public static void launchBrowser(String browserName, String URL) throws IOException {
		//loadPropertiesFile();
		if (browserName.equalsIgnoreCase("Firefox") || browserName.equalsIgnoreCase("FF")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\main\\resources\\BrowserDrivers\\geckodriver.exe");
			webDriver = new FirefoxDriver();
			log.debug("Launching FF browser");
		} else if (browserName.equalsIgnoreCase("Chrome")) {
			//System.out.println(System.getProperty("user.dir"));
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\resources\\BrowserDrivers\\chromedriver.exe");
			webDriver = new ChromeDriver();
			log.debug("Launching Chrome browser");
		} else if (browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "\\src\\main\\resources\\BrowserDrivers\\IEDriverServer.exe");
			webDriver = new InternetExplorerDriver();
			log.debug("Launching IE browser");
		} else {
			// TODO
		}
		getDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(URL);
		report.log(LogStatus.PASS, "Successfully launched URL : "+URL);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@AfterTest(alwaysRun=true)
	public void closeBrowser(){	
		
		driver.close();
		report.log(LogStatus.PASS, "Closed the browser");
		
	}
}
