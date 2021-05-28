package com.Utilities;

import org.openqa.selenium.By;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
//import org.apache.http.client.fluent.Request;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import com.relevantcodes.extentreports.LogStatus;



public class ActionKeywords extends Base{






	/******************************************************************************************************************************/
	public static WebDriverWait wait;
	
	
	
	
	

	

	

	

	

	/************************************************************************************************************************************/
	/**
	 * @author Harpreet Kaur
	 * @param objLocator: Action to be performed on element (Get it from Object repository)
	 * @param sLocatorName: Meaningful name to the element (Ex:Login Button, SignIn Link etc..)
	 * @throws Throwable 
	 */
	/**********************************************************************************************************************************/
	public void click(By objLocator, String sLocatorName)
			throws Throwable {
		
		try {
			
			driver.findElement(objLocator).click();			
			
			report.log(LogStatus.PASS, "Clicked on " + sLocatorName);
			
		} catch (Exception e) {
			report.log(LogStatus.FAIL, "Failed to click on " + sLocatorName);

			
		} 
	}


	

	/************************************************************************************************************************************/
	/**
	 * @author Harpreet Kaur
	 * @param objLocator: Action to be performed on element (Get it from Object repository)
	 * @param sLocatorName: Meaningful name to the element (Ex:Login Button, SignIn Link etc..)
	 * @throws Throwable 
	 */
	/*****************************************************************************************************************************/
	public void jsClick(By objLocator, String sLocatorName)
			throws Throwable {
		
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", driver.findElement(objLocator));
			
			report.log(LogStatus.PASS, "Clicked on " + sLocatorName);
		} catch (Exception e) {
			report.log(LogStatus.FAIL, "Failed to click on " + sLocatorName);
			} 
	}

	/******************************************************************************************************************************/
	/**
	 * @author Harpreet Kaur
	 * Assert Title of the page.
	 * @param sTitle: Expected title of the page.
	 */
	/******************************************************************************************************************************/
	public void assertTitle(String sTitle) throws Throwable {
		String title = "";
		try{
			title = getTitle();
			Assert.assertEquals(getTitle(), sTitle);
			
		}catch(Exception ex){
			report.log(LogStatus.FAIL, "Failed to verify title. Expected title is " + sTitle +" Actual title is " + title);
			ex.printStackTrace();
			
		}
	}

	/******************************************************************************************************************************/
	/**
	 * @author Harpreet Kaur
	 * @param objLocator
	 * @param visibletext
	 * @param sLocatorName
	 * @throws Throwable
	 */
	/******************************************************************************************************************************/
	public void selectByVisibleText(By objLocator, String visibletext,String sLocatorName) throws Throwable {
		try {
			Select dropDown = new Select(driver.findElement(objLocator));           
			dropDown.selectByVisibleText(visibletext);
			report.log(LogStatus.PASS, "Selected " + visibletext + " from " + sLocatorName);
		} catch (Exception e) {
			report.log(LogStatus.FAIL, "Failed to select " + visibletext + " from " + sLocatorName);
		} 
	}

	/******************************************************************************************************************************/
	/**
	 * @author Harpreet Kaur
	 * @param by
	 * @return boolean
	 * verify element is present or not
	 */
	/******************************************************************************************************************************/
	public boolean isElementPresent(By by)
			throws Throwable {
		try {
			driver.findElement(by);
			return true;
		} catch (Exception e) {
			return false;
		} 
	}

	
	/******************************************************************************************************************************/
	/**
	 * This method returns check existence of element
	 * @author Harpreet Kaur
	 * @param locator: Action to be performed on element (Get it from Object repository)
	 * @param sLocatorName : Meaningful name to the element (Ex:Textbox, checkbox etc)
	 * @return: Boolean value(True or False)
	 * @throws NoSuchElementException
	 */
	/******************************************************************************************************************************/
	public boolean isElementPresent(By by, String sLocatorName) throws Throwable {
		boolean flag=false;	
		try {
			driver.findElement(by);
			flag = true;
			report.log(LogStatus.PASS, "Element " + sLocatorName +" is present");

		} catch (Exception e) {
			report.log(LogStatus.FAIL, "Element " + sLocatorName +" is not present");
			

		} 

		return flag;
	}
	/******************************************************************************************************************************/
	/**
	 * This method used type value in to text box or text area
	 * @author Harpreet Kaur
	 * @param locator: Action to be performed on element (Get it from Object repository)
	 * @param testdata: Value wish to type in text box / text area
	 * @param locatorName: Meaningful name to the element (Ex:Textbox,Text Area etc..)
	 * @throws NoSuchElementException
	 */
	/******************************************************************************************************************************/
	public void type(By objLocator, String sValue, String sLocatorName)
			throws Throwable {
		
		try {
			//driver.findElement(objLocator).sendKeys(" ");
			driver.findElement(objLocator).clear();
			driver.findElement(objLocator).sendKeys(sValue);
			report.log(LogStatus.PASS, "Entered " +  sValue+ " in " + sLocatorName);
			
		} catch (Exception e) {
			report.log(LogStatus.FAIL, "Failed to enter " +  sValue+ " in " + sLocatorName);
		} 
	}

	/******************************************************************************************************************************/
	/**
	 * Moves the mouse to the middle of the element. The element is scrolled
	 * into view and its location is calculated using getBoundingClientRect.
	 * @author Harpreet Kaur
	 * @param locator: Action to be performed on element (Get it from Object repository)
	 * @param locatorName: Meaningful name to the element (Ex:link,menus  etc..)
	 * @throws
	 * */
	/******************************************************************************************************************************/
	public void mouseover(By objLocator, String sLocatorName)
			throws Throwable {
		
		try {
			WebElement mo = driver.findElement(objLocator);
			new Actions(driver).moveToElement(mo).build().perform();
			report.log(LogStatus.PASS, "Successfully Mouse hover on " + sLocatorName);
		} catch (Exception e) {
			report.log(LogStatus.FAIL, "Failed to Mouse hover on " + sLocatorName);
		} 
	}

	/******************************************************************************************************************************/
	/**
	 * A convenience method that performs click-and-hold at the location of the
	 * source element, moves by a given offset, then releases the mouse.
	 * @author Harpreet Kaur
	 * @param source: Element to emulate button down at.
	 * @param xOffset: Horizontal move offset.
	 * @param yOffset: Vertical move offset.
	 * @param sLocatorName: locator name
	 */
	/******************************************************************************************************************************/
	public void draggable(By objSource, int x, int y, String sLocatorName)
			throws Throwable {
		
		try {
			WebElement dragitem = driver.findElement(objSource);
			new Actions(driver).dragAndDropBy(dragitem, x, y).build().perform();
			
				  report.log(LogStatus.PASS, "Draggable Action is Done on " + sLocatorName);
				 
		
		} catch (Exception e) {
			
			  report.log(LogStatus.FAIL, "Draggable action is not performed on " +
			  sLocatorName);
			 

		} 
	}

	/******************************************************************************************************************************/
	/**
	 * A convenience method that performs click-and-hold at the location of the
	 * source element, moves to the location of the target element, then
	 * releases the mouse.
	 * @author Harpreet Kaur
	 * @param source: Element to emulate button down at.
	 * @param target: Element to move to and release the mouse at.
	 * @param locatorName: Meaningful name to the element (Ex:Button,image etc..)
	 * @return boolean
	 */
	/******************************************************************************************************************************/
	public boolean draganddrop(By objSource, By byTarget, String sLocatorName)
			throws Throwable {
		boolean flag=false;	
		try {
			WebElement from = driver.findElement(objSource);
			WebElement to = driver.findElement(byTarget);
			new Actions(driver).dragAndDrop(from, to).perform();
			flag = true;
			
				report.log(LogStatus.PASS,
						"Drag And Drop Action is performed on " + sLocatorName);
			
			
		} catch (Exception e) {
			report.log(LogStatus.FAIL,
					"Failed to perform Drag And Drop action on " + sLocatorName);

			
		} 
		return flag;
	}

	/******************************************************************************************************************************/
	/**
	 * To slide an object to some distance
	 * @author Harpreet Kaur
	 * @param slider: Action to be performed on element
	 * @param xOffset
	 * @param yOffset
	 * @param locatorName: Meaningful name to the element (Ex:Login Button, SignIn Link etc..)
	 */
	/******************************************************************************************************************************/
	public void slider(By bySlider, int x,int y,String sLocatorName) throws Throwable {
		
		try {
			WebElement dragitem = driver.findElement(bySlider);
			new Actions(driver).dragAndDropBy(dragitem, x, y).build().perform();//150,0
			report.log(LogStatus.PASS, "Slider action is performed on " + sLocatorName);
				
		} catch (Exception e) {
			report.log(LogStatus.FAIL, "Failed to perform slider Action on " + sLocatorName);
			
		} 
	}

	/******************************************************************************************************************************/
	/**
	 * To right click on an element
	 * @author Harpreet Kaur
	 * @param by: Action to be performed on element (Get it from Object repository)
	 * @param locatorName: Meaningful name to the element (Ex:Login Button, SignIn Link etc..)
	 * @throws Throwable
	 */
	/******************************************************************************************************************************/
	public void rightclick(By by, String sLocatorName) throws Throwable {
		
		try {
			WebElement elementToRightClick = driver.findElement(by);
			Actions clicker = new Actions(driver);
			clicker.contextClick(elementToRightClick).perform();
			report.log(LogStatus.PASS, "Performed Right Click on " + sLocatorName);
			
		} catch (Exception e) {
			report.log(LogStatus.FAIL, "Failed to perform Right Click on " +
			  sLocatorName);
			 } 
	}

	
	
	/******************************************************************************************************************************/
	/**
	 * select value from DropDown by using selectByIndex
	 * @author Harpreet Kaur
	 * @param locator: Action to be performed on element (Get it from Object repository)
	 * @param index: Index of value wish to select from dropdown list.
	 * @param locatorName: Meaningful name to the element (Ex:Year Dropdown, items Listbox etc..)
	 */
	/******************************************************************************************************************************/
	public void selectByIndex(By objLocator, int index, String sLocatorName)
			throws Throwable {
		
		try {
			Select s = new Select(driver.findElement(objLocator));
			s.selectByIndex(index);
			 report.log(LogStatus.PASS,
				  "Option at index "+index+" is Selected from "+ sLocatorName +" DropDown");
				  
		} catch (Exception e) {
			
			  report.log(LogStatus.FAIL,
			  "Option at index "+index+" is Not Selected from "+ sLocatorName +" DropDown");
			 
			
		} 
	}

	/******************************************************************************************************************************/
	/**
	 * select value from DD by using value
	 * @author Harpreet Kaur
	 * @param locator: Action to be performed on element (Get it from Object repository)
	 * @param value: Value wish to select from dropdown list.
	 * @param locatorName: Meaningful name to the element (Ex:Year Dropdown, items Listbox etc..)
	 */
	/******************************************************************************************************************************/
	public void selectByValue(By objLocator, String sValue, String sLocatorName)
			throws Throwable {
		
		try {
			Select s = new Select(driver.findElement(objLocator));
			s.selectByValue(sValue);
			report.log(LogStatus.PASS, "Selected " + sValue + " from " + sLocatorName);
		} catch (Exception e) {
			report.log(LogStatus.FAIL, "Failed to select " + sValue + " from " + sLocatorName);
			e.printStackTrace();
		}
	}



	/******************************************************************************************************************************/
	/**
	 * SWITCH TO WINDOW BY USING TITLE
	 * @author Harpreet Kaur
	 * @param windowTitle: Title of window wish to switch
	 * 
	 */
	/******************************************************************************************************************************/
	public void switchWindowByTitle(String sWindowTitle)
			throws Throwable {
		boolean flag = false;
		try {
			Set<String> windowList = driver.getWindowHandles();
			
			for (String window : windowList) {
				if(driver.switchTo().window(window).getTitle().trim().equals(sWindowTitle)) {
					flag=true;
					break;
				}
				
			}
			if (flag) {
				
				  report.log(LogStatus.PASS,
				  "Switched to the window with title " + sWindowTitle);				 
			} else {
				report.log(LogStatus.FAIL,
						  "Failed to switch to the window with title " + sWindowTitle);		
			}
			
		} catch (Exception e) {
			report.log(LogStatus.FAIL,
					  "Failed to switch to the window with title " + sWindowTitle);
		} 
	}

	

	
	/******************************************************************************************************************************/
	/**
	 * Verify alert present or not
	 * @author Harpreet Kaur
	 * @param  String: alertText
	 */
	/******************************************************************************************************************************/
	public void verifyAlertText(String sText) throws Throwable {
		
		try {
			// Check the presence of alert
			Alert alert = driver.switchTo().alert();
			
			String alertText = alert.getText();
			Assert.assertEquals(alertText.trim(), sText);
			report.log(LogStatus.PASS, "The Alert is present with text " + alertText);
			
		} catch (NoAlertPresentException ex) {
			report.log(LogStatus.FAIL, "Failed to verify the alert");
			ex.printStackTrace();
			
		}
		
	}

	/******************************************************************************************************************************/
	/**
	 * alert Dismiss
	 * @author Harpreet Kaur
	 * 
	 * @throws Throwable
	 */
	/******************************************************************************************************************************/
	public void alertDismiss() throws Throwable {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			alert.dismiss();
			report.log(LogStatus.PASS, "Successfully dismissed the alert with text " +alertText);
			
		} catch (NoAlertPresentException ex) {
			report.log(LogStatus.FAIL, "Failed to verify the alert");
			ex.printStackTrace();
		} 

	}

	/******************************************************************************************************************************/
	/**
	 * To launch URL
	 * @author Harpreet Kaur
	 * @param url: url value want to launch
	 * @throws Throwable 
	 */
	/******************************************************************************************************************************/
	public void launchUrl(String sURL) throws Throwable {
		
		try{
			driver.manage().deleteAllCookies();
			driver.navigate().to(sURL);
			
			report.log(LogStatus.PASS, "Successfully launched URL : "+sURL);
			
			
		}catch(Exception e){
			report.log(LogStatus.FAIL, "Failed to launch URL : "+sURL);

			
		}
	}

	/******************************************************************************************************************************/
	/**
	 * This method verify check box is checked or not
	 * @author Harpreet Kaur
	 * @param locator: Action to be performed on element (Get it from Object repository)
	 * @param locatorName: Meaningful name to the element (Ex:sign in Checkbox etc..)
	 * @return: boolean value(True: if it is checked, False: if not checked)
	 */
	/******************************************************************************************************************************/
	public boolean isChecked(By objLocator, String sLocatorName) throws Throwable {
		
		boolean flag=false;
		try {
			if (driver.findElement(objLocator).isSelected()) {
				flag=true;
				
			}			
				  report.log(LogStatus.PASS, sLocatorName + " is selected");
				 
		} catch (NoSuchElementException e) {
			report.log(LogStatus.FAIL, sLocatorName + " is not selected");
			
			}
		return flag;
	}

	

	/******************************************************************************************************************************/
	/**
	 * Element is enable or not
	 * @author Harpreet Kaur
	 * @param locator: Action to be performed on element (Get it from Object repository)
	 * @param locatorName:  Meaningful name to the element (Ex:Login Button, UserName Textbox etc..)
	 * @return: boolean value (True: if the element is enabled, false: if it not enabled).
	 */
	/******************************************************************************************************************************/
	public boolean isEnabled(By objLocator, String sLocatorName) throws Throwable {
		boolean flag=false;
		try {
			if (driver.findElement(objLocator).isEnabled()) {
				flag=true;
				
			}
			
				  report.log(LogStatus.PASS, sLocatorName + " is enabled");
				 
		} catch (Exception e) {
			
			 report.log(LogStatus.FAIL, sLocatorName + " is not enabled");
			 flag=false;
		} 
		return flag;
	}

	/******************************************************************************************************************************/
	/**
	 * Element visible or not
	 * @author Harpreet Kaur
	 * @param locator: Action to be performed on element (Get it from Object repository)
	 * @param locatorName: Meaningful name to the element (Ex:Login Button, SignIn Link etc..)
	 * @return: boolean value(True: if the element is visible, false: If element not visible)
	 */
	/******************************************************************************************************************************/
	public boolean isVisible(By objLocator, String sLocatorName) throws Throwable {
		boolean flag=false;
		try {
			if(driver.findElement(objLocator).isDisplayed())
				flag=true;
			 report.log(LogStatus.PASS, sLocatorName + " element is visible");
			
		} catch (Exception e) {
			
			  report.log(LogStatus.FAIL, sLocatorName + " element is not visible");
			  flag=false;
		} 
		return flag;
	}

	/******************************************************************************************************************************/
	/**
	 * Get the CSS value of an element
	 * @author Harpreet Kaur
	 * @param locator: Action to be performed on element (Get it from Object repository)
	 * @param locatorName: Meaningful name to the element (Ex:Login Button, label color etc..)
	 * @param cssattribute: CSS attribute name wish to verify the value (id, name, etc..)
	 * @return: String CSS value of the element
	 */
	/******************************************************************************************************************************/
	public  String getCssValue(By objLocator, String sCSSAttribute,
			String sLocatorName) throws Throwable {
		String value = "";
		
		try{
			if (isElementPresent(objLocator, sLocatorName)) {
				value = driver.findElement(objLocator).getCssValue(sCSSAttribute);
				
			}
			
			report.log(LogStatus.PASS, "The CSS value for " + sLocatorName + " is " + value);
			
		}catch(Exception e){
			
			report.log(LogStatus.FAIL, "Failed to retrieve CSS value for " + sLocatorName);			
		}
		return value;
	}

	/******************************************************************************************************************************/
	/**
	 * Check the expected value is available or not
	 * @author Harpreet Kaur
	 * @param expvalue: Expected value of attribute
	 * @param locator: Action to be performed on element (Get it from Object repository)
	 * @param attribute: Attribute name of element wish to assert 
	 * @param locatorName: Meaningful name to the element (Ex:link text, label text etc..)
	 */
	/******************************************************************************************************************************/
	public void assertValue(String sExpvalue, By objLocator,
			String sAttribute, String sLocatorName) throws Throwable {
		String actualValue="";
		try{
			actualValue = getAttribute(objLocator, sAttribute, sLocatorName);
			Assert.assertEquals(sExpvalue, actualValue);
			report.log(LogStatus.PASS, "Value of " + sLocatorName +" is same as expected value " + sExpvalue);
		}catch(Exception e){
			e.printStackTrace();
			report.log(LogStatus.FAIL, "Value of " + sLocatorName +" is not same as expected value. Expected value is " + sExpvalue +" but displaying " + actualValue);
		}
		
	}

	/******************************************************************************************************************************/
	/**
	 * Check the text is presnt or not
	 * @author Harpreet Kaur
	 * @param text: Text wish to assert on the page.
	 */
	/******************************************************************************************************************************/
	public  void assertTextPresent(String sText) throws Throwable {
		
		try{
			Assert.assertTrue(driver.getPageSource().contains(sText));
			
			report.log(LogStatus.PASS, sText+" text is present on the page");
			
		}catch(Exception e){
			e.printStackTrace();
			report.log(LogStatus.FAIL, sText+" text is not present on the page");
			

		}
		
	}

	/******************************************************************************************************************************/
	/**
	 * Assert element present or not
	 * @author Harpreet Kaur
	 * @param by: Action to be performed on element (Get it from Object repository)
	 * @param locatorName: Meaningful name to the element (Ex:Login Button, SignIn Link etc..)
	 */
	/******************************************************************************************************************************/
	public void assertElementPresent(By objLocator, String sLocatorName)
			throws Throwable {
		
		try{
			Assert.assertTrue(isElementPresent(objLocator, sLocatorName));
			report.log(LogStatus.PASS, sLocatorName+" element is present on the page");
			
		}catch(Exception e){
			e.printStackTrace();
			report.log(LogStatus.FAIL, sLocatorName+" element is not present on the page");
			
		}
	}

	/******************************************************************************************************************************/
	/**
	 * Assert text on element 
	 * @author Harpreet Kaur
	 * @param by: Action to be performed on element (Get it from Object repository)
	 * @param text: expected text to assert on the element
	 */
	/******************************************************************************************************************************/
	public void assertTextEquals(By objLocator, String sText) throws Throwable {
		String actualText = "";
		try{
			actualText = getText(objLocator, sText).trim();
			Assert.assertEquals(actualText, sText.trim());
			
			report.log(LogStatus.PASS, "Actual text is same as expected text " + actualText);
			
			
		}catch(Exception e){ 
			e.printStackTrace();
			report.log(LogStatus.FAIL, "Actual text is not same as expected text. Text displayed is " + actualText + " but expected is " + sText);
		}
	}

	/******************************************************************************************************************************/
	/**
	 * Assert text on element 
	 * @author Harpreet Kaur
	 * @param by: Action to be performed on element (Get it from Object repository)
	 * @param text: expected text to assert on the element
	 * @param locatorName: Meaningful name to the element (Ex:link text, label text etc..)
	 */
	/******************************************************************************************************************************/
	public void verifyTextEquals(By objLocator, String sText,String sLocatorName) throws Throwable {
		
		try{
			String actualText=getText(objLocator, sLocatorName).trim();
			if(actualText.equals(sText.trim()))			
				report.log(LogStatus.PASS, sText+" text is same as expected text");
			else
				report.log(LogStatus.ERROR, sText+" text is not same as expected. Actual text is "+actualText + " but expected is " + sText);
		}catch(Exception e){
			report.log(LogStatus.FAIL, "Failed to verify text is same as expected text");
			
		}
	}

	/******************************************************************************************************************************/
	/**
	 * @author Harpreet Kaur
	 * @return: return title of current page.
	 * @throws Throwable
	 */
	/******************************************************************************************************************************/
	public String getTitle() throws Throwable {

		String text = driver.getTitle();
		report.log(LogStatus.PASS, "Title of the page is " + text);
		return text;
	}

	
	/******************************************************************************************************************************/
	/**
	 * Verify Title of the page.
	 * @author Harpreet Kaur
	 * @param title: Expected title of the page.
	 *  
	 */
	/******************************************************************************************************************************/
	public void verifyTitle(String title) throws Throwable {

		try{
			if(getTitle().equals(title)){
				report.log(LogStatus.PASS," Page title is verified as " + title);
			} else {
				report.log(LogStatus.ERROR,"Page title is not verified as " + title);
			}
			
			
		}catch(Exception e){
			report.log(LogStatus.FAIL,"Failed to verify page title");	
		}
	}

	/******************************************************************************************************************************/
	/**
	 * Verify text present or not
	 * @author Harpreet Kaur
	 * @param text: Text wish to verify on the current page.
	 * 
	 */
	/******************************************************************************************************************************/
	public void  verifyTextPresent(String text) throws Throwable
	{  
		
		if(driver.getPageSource().contains(text))
		{
			report.log(LogStatus.PASS, text + " text is present on the page");
			
		} else {
			report.log(LogStatus.ERROR, text + " text is not present on the page");
		}
		

		
	}

	/******************************************************************************************************************************/
	/**
	 * Get the value of a the given attribute of the element.
	 * @author Harpreet Kaur
	 * @param by: Action to be performed on element (Get it from Object repository)
	 * 
	 * @param attribute: Attribute name wish to assert the value.
	 * 
	 * @param locatorName: Meaningful name to the element (Ex:label, SignIn Link etc..)
	 * 
	 * @return: String attribute value
	 * 
	 */
	/******************************************************************************************************************************/
	public String getAttribute(By by, String attribute,
			String locatorName) throws Throwable {
		String value = "";
		if (isElementPresent(by, locatorName)) {
			value = driver.findElement(by).getAttribute(attribute);
		}
		return value;
	}

	
	/******************************************************************************************************************************/
	/**
	 * The innerText of this element.
	 * @author Harpreet Kaur
	 * @param locator: Action to be performed on element (Get it from Object repository)
	 * 
	 * @param locatorName: Meaningful name to the element (Ex:label text, SignIn Link etc..)
	 * 
	 * @return: String return text on element
	 * 
	 */
	/******************************************************************************************************************************/
	public String getText(By locator, String locatorName)
			throws Throwable {
		String text = "";
		
		try{			
				text = driver.findElement(locator).getText();
				
				report.log(LogStatus.PASS, locatorName + " element contains text " + text);
			
		}catch(Exception e){
			e.printStackTrace();
			report.log(LogStatus.FAIL, "Unable to get text from " + locatorName);
			
		}
		return text;
	}

	/******************************************************************************************************************************/
	/**
	 * Capture Screenshot
	 * @author Harpreet Kaur
	 * @param fileName: FileName screenshot save in local directory
	 * 
	 */
	/******************************************************************************************************************************/
	public File screenShot(String fileName) {
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		try {
			
			FileUtils.copyFile(scrFile, new File(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return scrFile;
	}

	/******************************************************************************************************************************/
	/**
	 * Click on the Link
	 * @author Harpreet Kaur
	 * @param locator: Action to be performed on element (Get it from Object repository)
	 * 
	 * @param locatorName: Meaningful name to the element (Ex:SignIn Link, menu's etc..)
	 */
	/******************************************************************************************************************************/
	public void mouseHoverByJavaScript(By locator, String locatorName)
			throws Throwable {
		
		try {
			WebElement mo = driver.findElement(locator);
			String javaScript = "var evObj = document.createEvent('MouseEvents');"
					+ "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
					+ "arguments[0].dispatchEvent(evObj);";
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(javaScript, mo);
			
			report.log(LogStatus.PASS, "Successfully performed mouser hover on " + locatorName);
				
			
		}catch (Exception e) {
			
			  report.log(LogStatus.FAIL, "Failed to perform mouse hover on " +
			  locatorName);
			 
			
		} 
	}

	/******************************************************************************************************************************/
	/**
	 * This method switch the focus to selected frame using frame index
	 * @author Harpreet Kaur
	 * @param index: Index of frame wish to switch
	 * 
	 */
	/******************************************************************************************************************************/
	public void switchToFrameByIndex(int index) throws Throwable{
		
		try{
			driver.switchTo().frame(index);
			
			report.log(LogStatus.PASS, "Successfully switched to frame with index " + index);
				 
		}
		catch(Exception e){
			
			report.log(LogStatus.FAIL, "Failed to switch to frame with index " + index);
			 
			
		}
	}

	/******************************************************************************************************************************/
	/**
	 * This method switch the to frame using frame ID.
	 * @author Harpreet Kaur
	 * @param idValue: Frame ID wish to switch
	 * 
	 */
	/******************************************************************************************************************************/
	public void switchToFrameById(String idValue)throws Throwable
	{  
		
		try
		{
			driver.switchTo().frame(idValue);
			
			report.log(LogStatus.PASS, "Successfully switched to frame with id " + idValue);
			 
		}
		catch(Exception e){
			
			report.log(LogStatus.FAIL, "Failed to switch to frame with id " + idValue);
			 
			
		}
	}

	/******************************************************************************************************************************/
	/**
	 * This method switch the to frame using frame Name.
	 * @author Harpreet Kaur
	 * @param nameValue: Frame Name wish to switch
	 * 
	 */
	/******************************************************************************************************************************/
	public void switchToFrameByName(String nameValue)throws Throwable
	{  
	try
	{
		driver.switchTo().frame(nameValue);
		report.log(LogStatus.PASS, "Successfully switched to frame with name " + nameValue);
		 
	}
	catch(Exception e){
		
		report.log(LogStatus.FAIL, "Failed to switch to frame with name " + nameValue);
		 
		
	}
	}

	/******************************************************************************************************************************/
	/**
	 * This method switch the to Default Frame.
	 * @author Harpreet Kaur
	 * @throws Throwable 
	 */
	/******************************************************************************************************************************/
	public void switchToDefaultFrame() throws Throwable{ 
		
		try
		{
			driver.switchTo().defaultContent();
			report.log(LogStatus.PASS, "Successfully switched to default frame");
			 
		}
		catch(Exception e){
			
			report.log(LogStatus.FAIL, "Failed to switch to default frame");
			 
			
		}
	}

	/******************************************************************************************************************************/
	/**
	 * This method switch the to frame using frame Name.
	 * @author Harpreet Kaur
	 * @param nameValue: Frame Name wish to switch
	 * 
	 * @param locatorName :   Meaningful name to the element (Ex:SignIn Link, login button etc..)
	 * 
	 * 
	 */
	/******************************************************************************************************************************/
	public void switchToFrameByLocator(By lacator,String locatorName)throws Throwable
	{  
		
		try
		{
			driver.switchTo().frame(driver.findElement(lacator));
			report.log(LogStatus.PASS, "Successfully switched to frame with locator " + locatorName);
			 
		}
		catch(Exception e){
			
			report.log(LogStatus.FAIL, "Failed to switch to frame with locator " + locatorName);
			 
			
		}
	}

	/******************************************************************************************************************************/
	/**
	 * This method waits until element present on web page.
	 * @author Harpreet Kaur
	 */
	/******************************************************************************************************************************/
	public void ImplicitWait(){

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	/******************************************************************************************************************************/
	/**
	 * Click on Element
	 * @author Harpreet Kaur
	 * @param locator: Action to be performed on element (Get it from Object repository)
	 * 
	 * @param locatorName: Meaningful name to the element (Ex:SignIn Link, login button etc..)
	 * 
	 * @throws StaleElementReferenceException - If the element no longer exists as initially defined
	 */
	/******************************************************************************************************************************/
	public void click(WebElement locator,String locatorName ) throws Throwable
	{
		
		try {
			locator.click();
			
			report.log(LogStatus.PASS, "Successfully clicked on " + locatorName);
				
		} catch (Exception e) {
			report.log(LogStatus.FAIL, "Failed to click on " + locatorName);
			
		}
	}	
	/******************************************************************************************************************************/
	/**
	 * 
	 *  This method waits driver until given driver time.
	 *  @author Harpreet Kaur
	 *  @param lTime: Wait time 
	 */
	/******************************************************************************************************************************/
	public WebDriverWait driverwait(long lTime){

		wait = new WebDriverWait(driver, lTime);
		return wait;
	}
	/******************************************************************************************************************************/
	/**
	 *  This method waits until visibility of Elements on WebPage.
	 *  @author Harpreet Kaur
	 * @param objLocator: Action to be performed on element (Get it from Object repository)
	 * @param lTime: wait for visibility of  the element untill specified time
	 */
	/******************************************************************************************************************************/
	public void waitForVisibilityOfElement(By objLocator,long lTime){
		try{
			wait = driverwait(lTime);
			wait.until(ExpectedConditions.visibilityOfElementLocated(objLocator));
			
		}
		catch(Exception e){
			report.log(LogStatus.FAIL, "Failed to found element after wait for " + lTime);
		}
	}
	/******************************************************************************************************************************/
	/**
	 *  This method wait driver until Invisibility of Elements on WebPage.
	 *  @author Harpreet Kaur
	 * @param objLocator: Action to be performed on element (Get it from Object repository)
	 *   
	 * @param by: Action to be performed on element (Get it from Object repository)
	 * 
	 */
	/******************************************************************************************************************************/
	public void waitForInVisibilityOfElement(By objLocator, long lTime){

		try {
			wait = driverwait(lTime);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(objLocator));
		} catch (Exception e) {
			report.log(LogStatus.FAIL, "Element is still visible after wait for " + lTime);
		}

	}

	/******************************************************************************************************************************/
	/**
	 * This method used type value in to Upload Input file text area
	 * @author Harpreet Kaur
	 * @param locator: Action to be performed on element (Get it from Object repository)
	 * 
	 * @param testdata: Value wish to type in text box / text area
	 *  
	 * @param locatorName: Meaningful name to the element (Ex:Textbox,Text Area etc..)
	 * 
	 * @throws NoSuchElementException
	 */
	/******************************************************************************************************************************/
	public void uploadFile(By locator, String testdata, String stepDescription)
			throws Throwable {
		
		try {
			driver.findElement(locator).sendKeys(testdata);
			report.log(LogStatus.PASS, "Successfully uploaded the file " + testdata);
		} catch (Exception e) {
			report.log(LogStatus.FAIL, "Failed to upload the file " + testdata);
		
		}
	}
	
	/******************************************************************************************************************************/
	/**
	 * @author Harpreet Kaur
	 * @param locator
	 * @return
	 */
	/******************************************************************************************************************************/
	public List<WebElement> getElements(By locator){

		List<WebElement> list=driver.findElements(locator);

		return list;
	}

	/******************************************************************************************************************************/
	/**
	 * @author Harpreet Kaur
	 * @param by
	 * @param text
	 * @param locatorName
	 * @return
	 * @throws Throwable
	 */
	/******************************************************************************************************************************/
	public void assertTextMatching(By by, String text,String locatorName) throws Throwable {
		
		try{
			String ActualText=getText(by, text).trim();
			Assert.assertTrue(ActualText.contains(text));
			
			report.log(LogStatus.PASS, locatorName + " element contains text " + text);
				
		}catch(Exception e){ 
			report.log(LogStatus.FAIL, locatorName + " element does not contain text " + text);
			
			
		}
	}

	/******************************************************************************************************************************/
	/** Fetches the first select value in the drop down.
	 * @author Harpreet Kaur
	 * @param locator
	 * @param locatorName
	 * @return
	 * @throws Throwable
	 */
	/******************************************************************************************************************************/
	public String getFirstSelectedOption(By locator, String locatorName)
			throws Throwable {
		String text = "";		
		try {
			Select select = new Select(driver.findElement(locator));
			text = select.getFirstSelectedOption().getText();
			
		} catch (Exception e) {
			
			  report.log(LogStatus.FAIL, "Failed to get text from " +
			  locatorName);		 
			
		} 
		return text;
	}

	

	


	/******************************************************************************************************************************/
	/**
	 * @author Harpreet Kaur
	 * @param locator
	 * @param locatorName
	 * @return
	 * @throws Throwable
	 */
	/******************************************************************************************************************************/
	public boolean isNotChecked(By locator, String locatorName) throws Throwable {
		
		boolean flag=false;
		try {
			if (!driver.findElement(locator).isSelected()) {
				flag=true;				
			}
			if(flag){
				
				 report.log(LogStatus.PASS, locatorName + " is not checked");								
			} else {
				report.log(LogStatus.ERROR, locatorName + " is checked");
			}
		} catch (NoSuchElementException e) {
			
			  report.log(LogStatus.FAIL, "Failed to verify element " + locatorName);		 
			
		} 
		return flag;
	}

	
	
	/**
	 * @author Harpreet Kaur
	 * Double click on the web element
	 * @param objLocator
	 * @return
	 */
	public void doubleClick(By objLocator, String locatorName){
		
		try{
			WebElement element = driver.findElement(objLocator);
			new Actions(driver).moveToElement(element).doubleClick().build().perform();
			report.log(LogStatus.PASS, "Successfully double clicked on " + locatorName);
		}catch(Exception e){
			report.log(LogStatus.FAIL, "Failed to double click on " + locatorName);
		}
		 
	}

	
	public void selectMultipleValuesByVisibleText(By objLocator, String sValues, String locatorName) throws Throwable {
		Select select = new Select(driver.findElement(objLocator));
		select.deselectAll();
		String[] options = sValues.split(",");
		for(String option : options) {
			selectByVisibleText(objLocator, option, locatorName);
	}

}
	
/******************************************************************************************************************************/


}
