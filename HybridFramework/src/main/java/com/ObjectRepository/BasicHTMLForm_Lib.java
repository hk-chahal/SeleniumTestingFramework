package com.ObjectRepository;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.Utilities.ActionKeywords;
import com.Utilities.Base;
import com.relevantcodes.extentreports.LogStatus;


public class BasicHTMLForm_Lib extends ActionKeywords{
	
	public static final By USERNAME = By.name("username");
	public static final By PASSWORD = By.name("password");
	public static final By COMMENTS = By.name("comments");
	public static final By BROWSE_FILE = By.name("filename");
	public static final By CHECKBOX_ITEM = By.name("checkboxes[]");
	public static final By RADIO_BTN = By.name("radioval");
	public static final By MULTISELECT_VALUES = By.name("multipleselect[]");
	public static final By DROPDOWN = By.name("dropdown");
	public static final By CANCEL_BTN = By.xpath("//input[@value='cancel']");
	public static final By SUBMIT_BTN = By.xpath("//input[@value='submit']");
	
	
	
	public void uploadFile(String filePath) throws Throwable {
		String browserName = Base.browser;
		jsClick(BROWSE_FILE, "Browse button");
		if(browserName.equalsIgnoreCase("Firefox") || browserName.equalsIgnoreCase("FF")) {
			Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\test\\resources\\com\\AutoITFiles\\FileUpload_FF.exe" +" " + filePath);
		} else if(browserName.equalsIgnoreCase("chrome")) {
			Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\test\\resources\\com\\AutoITFiles\\FileUpload_Chrome.exe" +" " + filePath);
		}
		report.log(LogStatus.INFO, getAttribute(BROWSE_FILE, "label", "Browse Name"));
		report.log(LogStatus.PASS, "Uploaded the file successfully");
	}
	
	
	public void selectCheckBox(String sOption, String locatorName) throws Throwable {
		
		List<WebElement> chkbx = getElements(CHECKBOX_ITEM);
		String value;
		for(WebElement option : chkbx) {
			if(option.isSelected())
				option.click();
		}
		for(WebElement option : chkbx) {
			value = option.getAttribute("value");
			if(value.equalsIgnoreCase(sOption))
				click(option, locatorName);
				break;
		}
		
	}
	
public void selectRadioBtn(String sOption, String locatorName) throws Throwable {
		
		List<WebElement> rbtn = getElements(RADIO_BTN);
		String value;
		for(WebElement option : rbtn) {
			value = option.getAttribute("value");
			if(value.equalsIgnoreCase(sOption))
				click(option, locatorName);
				break;
		}
		
	}
}
