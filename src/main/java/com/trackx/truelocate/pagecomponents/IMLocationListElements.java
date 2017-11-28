package com.trackx.truelocate.pagecomponents;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trackx.truelocate.common.utils.Constants;
import com.trackx.truelocate.common.utils.GeneralActions;
import com.trackx.truelocate.common.utils.ReusableActions;

public class IMLocationListElements {
	WebDriver driver;
	String Title, Value;
	ReusableActions inAction = new ReusableActions();
	GeneralActions genAction = new GeneralActions();
	Constants constants = new Constants();
	CommonElements commonElements = new CommonElements();

	/**
	 * Create screen Elements
	 */
	@FindBy(id = "createCode")
	WebElement txt_code;

	@FindBy(id = "createName")
	WebElement txt_name;

	@FindBy(id = "createDescription")
	WebElement txt_description;

	@FindBy(id = "select2-chosen-2")
	WebElement dropdown_facility;
	
	@FindBy(id = "s2id_autogen2_search")
	WebElement txt_faciltiy;

	@FindBy(xpath = "//*[@id=\"select2-results-2\"]/li")
	List<WebElement> list_facility;

	@FindBy(id = "select2-chosen-3")
	WebElement dropdown_locationtype;

	
	//@FindBy(id = "s2id_autogen3_search")
	@FindBy(id = "//*[@id='s2id_autogen3_search']")
	WebElement txt_locationtype;

	@FindBy(xpath = "//*[@id=\"select2-results-3\"]/li")
	List<WebElement> list_locationtype;

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
	@FindBy(xpath = "//*[@id='menuField']/ul[6]/li/a/span")
	WebElement menu_location;

	@FindBy(linkText = "Location List")
	WebElement menu_locationlist;

	public IMLocationListElements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method used to click Region menu
	 */
	public void menuClick() {
		try {
			inAction.buttonClick(driver, menu_location,
					"Click button : menu_inventory");
			inAction.buttonClick(driver, menu_locationlist,
					"Click button : menu_masterData");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method used to create Locationlist
	 * 
	 * @param sCode
	 * @param sName
	 * @param sDescription
	 * @param sFacility
	 * @param sFacility
	 * @param sDescription
	 * @param sLoactiontype
	 * @param sLoactiontype
	 * sLocationTypedropdown
	 */

	public void enterLocationListInfo(String sCode, String sName,
			String sFacility, String sFacilitydropdown, String sLoactiontype,
			String sLocationTypedropdown) {
		try {
			// inAction.waitForVisibilityOfElement(driver, txt_code);
			inAction.inputText(driver, txt_code, sCode, "Enter sCode : "
					+ sCode);
			// inAction.waitForVisibilityOfElement(driver, txt_name);
			inAction.inputText(driver, txt_name, sName, "Enter sFirstname : "
					+ sName);
			inAction.buttonClick(driver, dropdown_facility,
					"Click button : dropdown_faciltiy");
			inAction.inputText(driver, txt_faciltiy, sFacility,
					"Enter sFacilityanme : " + sFacility);
			inAction.selectByTextInDropdown(driver, list_facility,
					sFacilitydropdown);
			inAction.buttonClick(driver, dropdown_locationtype,
					"Click button : dropdown_locationtype");
			inAction.inputText(driver, txt_locationtype, sLoactiontype,
					"Enter sLocationtype : " + sLoactiontype);
			inAction.selectByTextInDropdown(driver, list_facility,
					sLocationTypedropdown);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
