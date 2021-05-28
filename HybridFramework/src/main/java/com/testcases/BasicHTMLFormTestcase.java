package com.testcases;

import org.testng.annotations.Test;


import com.ObjectRepository.BasicHTMLForm_Lib;
import com.ObjectRepository.HomePage;


public class BasicHTMLFormTestcase extends BasicHTMLForm_Lib{
		
	
	
	@Test
	public void basicHTMLFormTestcase() throws Throwable {
		
		String username = excel.getColumnDataByHeaderName("sUsername", "BasicHTMLForm");
		String password = excel.getColumnDataByHeaderName("sPassword", "BasicHTMLForm");
		String comment = excel.getColumnDataByHeaderName("sComment", "BasicHTMLForm");
		String uploadfilepath = excel.getColumnDataByHeaderName("sFilepath", "BasicHTMLForm");
		String checkbox = excel.getColumnDataByHeaderName("sCheckbox", "BasicHTMLForm");
		String radioBtn = excel.getColumnDataByHeaderName("sRadio", "BasicHTMLForm");
		String multiselect = excel.getColumnDataByHeaderName("sMultiSelect", "BasicHTMLForm");
		String dropdown = excel.getColumnDataByHeaderName("sDropdown", "BasicHTMLForm");
		
		launchBrowser(config.getProperty("browser"), config.getProperty("URL"));
		
		click(HomePage.HTML_FORM_EXAMPLE_LINK, "HTML Form Example Link");
		
		type(USERNAME, username, "Username");
		
		type(PASSWORD, password, "Password");
		
		type(COMMENTS, comment, "Comments");
		
		uploadFile(System.getProperty("user.dir") + uploadfilepath);
		
		selectCheckBox(checkbox, "Checkbox");
		
		selectRadioBtn(radioBtn, "Radio Button");
		
		selectMultipleValuesByVisibleText(MULTISELECT_VALUES, multiselect, "Multi-Select");
		
		selectByValue(DROPDOWN, dropdown, "Drop Down");
		
		click(CANCEL_BTN, "Cancel Button");
		
	}

}
