package com.trackx.truelocate.pagecomponents;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.trackx.truelocate.common.utils.Constants;
import com.trackx.truelocate.common.utils.GeneralActions;
import com.trackx.truelocate.common.utils.ReusableActions;

public class IMRegionElements {
	WebDriver driver;
	String Title, Value;
	ReusableActions inAction = new ReusableActions();
	GeneralActions genAction = new GeneralActions();
	Constants constants = new Constants();
	CommonElements commonElements = new CommonElements();
	
	
	/**
	 * Create screen Elements
	 */
	@FindBy(id="createCode")
	WebElement txt_code;
	
	@FindBy(id="createName")
	WebElement txt_name;
	
	
	
	/**
	 * View Screen Elements
	 */
	
	@FindBy(xpath = "//*[@id='view-form']/fieldset[1]/div/section[1]/label[2]")
	WebElement label_code;
	
	@FindBy(xpath = "//*[@id='view-form']/fieldset[1]/div/section[2]/label[2]")
	WebElement label_name;

	/**
	 * Menu Elements
	 */
	@FindBy(xpath = "//*[@id='menuField']/ul[11]/li/a/span")
	WebElement menu_administration;

	
	@FindBy(linkText = "Region")
	WebElement menu_region;
	
	public IMRegionElements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method used to click Region menu
	 */
	public void menuClick() {
		try {
			inAction.buttonClick(driver, menu_administration, 
					"Click button : menu_inventory");
			inAction.buttonClick(driver, menu_region, 
					"Click button : menu_masterData");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method used to create Region
	 * 
	 * @param sCode
	 * @param sName 
	 */
	public void enterRegionInfo(String sCode, String sName) {
		try {
			//inAction.waitForVisibilityOfElement(driver, txt_code);
			inAction.inputText(driver, txt_code, sCode,
					"Enter sCode : " + sCode);
			//inAction.waitForVisibilityOfElement(driver, txt_name);
			inAction.inputText(driver, txt_name, sName,
					"Enter sFirstname : " + sName);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	}
	
	

