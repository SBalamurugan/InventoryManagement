package com.trackx.truelocate.pagecomponents;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.trackx.truelocate.common.utils.Constants;
import com.trackx.truelocate.common.utils.GeneralActions;
import com.trackx.truelocate.common.utils.ReusableActions;

public class IdentifierTypeElements {
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
	
	
	@FindBy(xpath="//*[@id=\"isRfid-checkbox\"]")
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

	@FindBy(xpath = "//*[@id=\"menuField\"]/ul[2]/li/ul/li[4]/a")
	WebElement menu_masterData;

	@FindBy(xpath = "//*[@id=\"menuField\"]/ul[2]/li/ul/li[4]/ul/li[3]/a")
	WebElement menu_identifierType;
	
	public IdentifierTypeElements(WebDriver driver) {
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
			inAction.buttonClick(driver, menu_identifierType, 
					"Click button : menu_identifierType");
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
			System.out.println("SREDSDASDadADAS" + sRFID);
			if(sRFID.equalsIgnoreCase("Yes")){
				clickToggleButton();
				//inAction.waitForVisibilityOfElement(driver, togglebutton_RFID);
				//inAction.buttonClick(driver, togglebutton_RFID, 
					//s	"Click button : togglebutton_RFID");
				//Thread.sleep(1000);
				//togglebutton_RFID.click();
				selectProtocol(sProtocol);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickToggleButton() {
		inAction.waitForVisibilityOfElement(driver, togglebutton_RFID);
		inAction.buttonClick(driver, togglebutton_RFID, 
			"Click button : togglebutton_RFID");	}
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
