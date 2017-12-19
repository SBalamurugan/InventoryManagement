package com.trackx.truelocate.pagecomponents;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trackx.truelocate.common.utils.Constants;
import com.trackx.truelocate.common.utils.GeneralActions;
import com.trackx.truelocate.common.utils.ReusableActions;

public class IMIdentifierTypeElements {
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
	
	@FindBy(id="isRfid-checkbox")
	WebElement toggselection_RFID;
	
	@FindBy(className="onoffswitch-switch")
	WebElement togglebutton_RFID;
	
	@FindBy(id = "select2-chosen-2")
	WebElement dropdown_protocol;
	
	@FindBy(xpath = "//*[@id=\"select2-results-2\"]/li")
	List<WebElement> list_protocol;
	
	
	/**
	 * View Screen Elements
	 */
	@FindBy(xpath = "//*[@id=\"view-form\"]/fieldset[1]/div/section[1]/label[2]")
	WebElement label_code;
	
	
	@FindBy(xpath = "//*[@id=\"view-form\"]/fieldset[1]/div/section[2]/label[2]")
	WebElement label_name;
	
	@FindBy(id = "viewDescription")
	WebElement label_description;

	
	
	
	/**
	 * Menu Elements
	 */
	@FindBy(xpath = "//*[@id=\"menuField\"]/ul[2]/li/a/span")
	WebElement menu_inventory;

	@FindBy(linkText="Master Data")
	WebElement menu_masterData;

	@FindBy(linkText="Identifier Type")
	WebElement menu_identifierType;
	
	public IMIdentifierTypeElements(WebDriver driver) {
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
			inAction.linkClick(driver, menu_masterData,
					"Click link:menu_masterData");
			inAction.linkClick(driver, menu_identifierType, 
					"Click link: menu_identifierType");
						
			/*inAction.buttonClick(driver, menu_masterData, 
					"Click button : menu_masterData");
			inAction.buttonClick(driver, menu_identifierType, 
					"Click button : menu_identifierType");*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method used to create Identifier Type
	 * 
	 * @param sCode
	 * @param sName
	 * @param sRFID
	 * @param sProtocol
	 */
	public void enterIdentifierTypeInfo(String sCode, String sName, String sRFID, String sProtocol) {
		try {
			inAction.waitForVisibilityOfElement(driver,txt_code);
			inAction.inputText(driver, txt_code, sCode,
					"Enter sCode : " + sCode);
			inAction.waitForVisibilityOfElement(driver,txt_name);
			inAction.inputText(driver, txt_name, sName,
					"Enter sFirstname : " + sName);	
			clickRFID(sRFID);
		    selectProtocol(sProtocol);
			}
		 catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	/**
	 * This method used to click RFID toggle button
	 * 
	 * @param sRFID
	 */
	public void clickRFID(String sRFID) {
		boolean boovar = ReusableActions
				.isElementSelected(toggselection_RFID);
		String str = String.valueOf(boovar);
		if (!sRFID.equalsIgnoreCase(str)
				& StringUtils.isNotBlank(sRFID)) {
			inAction.waitForVisibilityOfElement(driver, togglebutton_RFID);
			ReusableActions.selectedRadioButton(driver, togglebutton_RFID,
					"click toggle button: togglebutton_RFID");
		}
	}
	/**
	 * This method used to select the protocol
	 * 
	 * @param protocol
	 */
	 public void selectProtocol(String protocol) {
		  try {
		    inAction.waitForElementToBeClickable(driver, dropdown_protocol);
		    inAction.buttonClick(driver, dropdown_protocol,
		      "Click protocol dropdown : " + protocol);
		    Thread.sleep(1000);
			inAction.selectByTextInDropdown(driver, list_protocol, protocol);
		  } catch (Exception e) {
			  e.printStackTrace();
		  }
	 }

}
