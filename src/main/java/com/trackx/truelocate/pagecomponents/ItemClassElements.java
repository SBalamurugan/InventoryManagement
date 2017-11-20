package com.trackx.truelocate.pagecomponents;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trackx.truelocate.common.utils.Constants;
import com.trackx.truelocate.common.utils.GeneralActions;
import com.trackx.truelocate.common.utils.ReusableActions;

public class ItemClassElements {
	WebDriver driver;
	String Title, Value;
	ReusableActions inAction = new ReusableActions();
	GeneralActions genAction = new GeneralActions();
	Constants constants = new Constants();
	CommonElements commonElements = new CommonElements();
	public Logger log4jlogger = Logger.getLogger("devpinoyLogger");
	
	/**
	 * Create screen Elements
	 */
	@FindBy(id="createCode")
	WebElement txt_code;
	
	@FindBy(id="createName")
	WebElement txt_name;
	
	@FindBy(id="createDescription")
	WebElement txt_description;
	
	/**
	 * View Screen Elements
	 */
	@FindBy(id = "viewCode")
	WebElement label_code;
	
	@FindBy(id = "viewName")
	WebElement label_name;
	
	@FindBy(id = "viewDescription")
	WebElement label_description;
	
	/**
	 * Menu Elements
	 */
	@FindBy(xpath = "//*[@id=\"menuField\"]/ul[2]/li/a/span")
	WebElement menu_inventory;

	@FindBy(xpath = "//*[@id=\"menuField\"]/ul[2]/li/ul/li[4]/a")
	WebElement menu_masterData;
	
	@FindBy(xpath = "//*[@id=\"menuField\"]/ul[2]/li/ul/li[4]/ul/li[1]/a")
	WebElement menu_itemClass;
	
	public ItemClassElements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method used to click the item class menu
	 */
	public void menuClick() {
		try {
			inAction.buttonClick(driver, menu_inventory, 
					"Click button : menu_inventory");
			inAction.buttonClick(driver, menu_masterData, 
					"Click button : menu_masterData");
			inAction.buttonClick(driver, menu_itemClass, 
					"Click button : menu_itemClass");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method used to create item class
	 * 
	 * @param sCode
	 * @param sName
	 * @param sDescription
	 */
	public void enterItemClassInfo(String sCode, String sName, String sDescription) {
		try {
			inAction.waitForVisibilityOfElement(driver, txt_code);
			inAction.inputText(driver, txt_code, sCode,
					"Enter sCode : " + sCode);
			inAction.waitForVisibilityOfElement(driver, txt_name);
			inAction.inputText(driver, txt_name, sName,
					"Enter sFirstname : " + sName);
			inAction.waitForVisibilityOfElement(driver, txt_description);
			inAction.inputText(driver, txt_description, sDescription,
					"Enter sLastname : " + sDescription);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
