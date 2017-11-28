package com.trackx.truelocate.pagecomponents;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.trackx.truelocate.common.utils.Constants;
import com.trackx.truelocate.common.utils.GeneralActions;
import com.trackx.truelocate.common.utils.ReusableActions;

public class IMProvisionElements {
	WebDriver driver;
	String Title, Value;
	ReusableActions inAction = new ReusableActions();
	GeneralActions genAction = new GeneralActions();
	Constants constants = new Constants();
	CommonElements commonElements = new CommonElements();
	
	
	/**
	 * Create screen Elements
	 */
	
	@FindBy(id = "select2-chosen-2")
	WebElement dropdown_item;
	
	@FindBy(id = "s2id_autogen2_search")
	WebElement txt_item;
	
	@FindBy(xpath = "//*[@id=\"select2-results-2\"]/li")
	List<WebElement> list_item;
	
	@FindBy(id = "select2-chosen-3")
	WebElement dropdown_facilitytype;
	
	@FindBy(id = "s2id_autogen3_search")
	WebElement txt_facilitytype;
	
	@FindBy(xpath = "//*[@id=\"select2-results-3\"]/li")
	List<WebElement> list_facilitytype;
	
	@FindBy(id = "select2-chosen-4")
	WebElement dropdown_locationtype;
	
	@FindBy(id = "s2id_autogen4_search")
	WebElement txt_locationtype;
	
	@FindBy(xpath = "//*[@id=\"select2-results-4\"]/li")
	List<WebElement> list_locationtype;
	
	@FindBy(id="createEntries")
	WebElement txt_entries;
	
	@FindBy(xpath = "//*[@id='assetProvisionTable']/tbody/tr/td[2]/label/input")
	WebElement txt_row;
	
	
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

	@FindBy(xpath = "//*[@id='menuField']/ul[3]/li/a/span")
	WebElement menu_asset;
	
	@FindBy(linkText="Provision")
	WebElement menu_provision;
	
	public IMProvisionElements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method used to click Provision menu
	 */
	public void menuClick() {
		try {
			inAction.buttonClick(driver, menu_asset, 
					"Click button : menu_asset");
			inAction.buttonClick(driver, menu_provision, 
					"Click button : menu_provision");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method used to create Provision
	 * 
	 * @param sItem
	 * @param sItemdropdown
	 * @param sFacilitytype
	 * @param sFacilitydropdown
	 * @param sLoactiontype
	 * @param sLocationTypedropdown
	 * @param sEntries
	 */
	
	public void enterProvisionListInfo(String sItem, String sItemdropdown, String sFacilitytype,String sFacilitydropdown,String sLoactiontype, String sLocationTypedropdown,String sStocknumber) {
		try {
			 selectItem(sItem,sItemdropdown);
			 selectFacilityType(sFacilitytype,sFacilitydropdown);
			 selectLocationType(sLoactiontype,sLocationTypedropdown);
			inAction.inputText(driver, txt_row, sStocknumber,
					"Enter sStocknumber : " + sStocknumber);		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method used to select item
	 * @param sItem
	 * @param sItemdropdown
	 */
   public void selectItem(String sItem,String sItemdropdown) {
	    try {
            inAction.buttonClick(driver, dropdown_item, 
		            "Click button : dropdown_item");
            inAction.inputText(driver, txt_item, sItem,
		             "Enter sItem : " + sItem);
            inAction.selectByTextInDropdown(driver, list_item, sItemdropdown);         
	 } catch (Exception e) {
		e.printStackTrace();
	 }
   }
	/**
	 * This method used to select Facility type
	
	 * @param sFacilitytype
	 * @param sFacilitydropdown
	 */
   public void selectFacilityType(String sFacilitytype,String sFacilitydropdown) {
	    try {
            inAction.buttonClick(driver, dropdown_facilitytype, 
			        "Click button : dropdown_facilitytype");
	        inAction.inputText(driver, txt_facilitytype, sFacilitytype,
			         "Enter sFacilitytype : " + sFacilitytype);
	        inAction.selectByTextInDropdown(driver, list_facilitytype, sFacilitydropdown);
	    } catch (Exception e) {
			e.printStackTrace();
		 }
	   }
	/**
	 * This method used to select Location type
	 * @param sLoactiontype
	 * @param sLocationTypedropdown
	 * @param sEntries
	 */
   public void selectLocationType(String sLoactiontype,String sLocationTypedropdown) {
	    try {
    inAction.buttonClick(driver, dropdown_locationtype, 
			"Click button : dropdown_locationtype");
	inAction.inputText(driver, txt_locationtype, sLoactiontype,
			"Enter sLocationtype : " + sLoactiontype);
	inAction.selectByTextInDropdown(driver, list_locationtype, sLocationTypedropdown);
	    } catch (Exception e) {
	 			e.printStackTrace();
	 		 }
	 	   }
   }


