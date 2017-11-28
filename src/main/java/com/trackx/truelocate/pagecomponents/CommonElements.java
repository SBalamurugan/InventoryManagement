package com.trackx.truelocate.pagecomponents;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.trackx.truelocate.common.utils.Constants;
import com.trackx.truelocate.common.utils.GeneralActions;
import com.trackx.truelocate.common.utils.ReusableActions;

public class CommonElements {
	WebDriver driver;
	String Title, Value;
	ReusableActions inAction = new ReusableActions();
	GeneralActions genAction = new GeneralActions();
	Constants constants = new Constants();
	//public Logger log4jlogger = Logger.getLogger("devpinoyLogger");
	
	@FindBy(xpath = "//*[@id=\"filterSlider\"]/header/button")
	WebElement btn_create;
	
	/**
	 * Create screen button
	 */
	@FindBy(xpath = "//*[@id=\"edit-form\"]/fieldset[2]/div/section[1]/div/button[1]")
	WebElement btn_createorupdate;
	
	@FindBy(xpath = "//*[@id=\"edit-form\"]/fieldset[2]/div/section[1]/div/button[2]")
	WebElement btn_cancel;
	
	/**
	 * View Screen button
	 */
	@FindBy(xpath = "//*[@id=\"view-form\"]/fieldset[2]/div/section/button[1]")
	WebElement btn_viewedit;

	@FindBy(xpath = "//*[@id=\"view-form\"]/fieldset[2]/div/section/button[2]")
	WebElement btn_viewdelete;

	@FindBy(xpath = "//*[@id=\"view-form\"]/fieldset[2]/div/section/button[3]")
	WebElement btn_viewcancel;
	
	/**
	 * Table elements
	 */
	@FindBy(className = "pageNo")
	WebElement pageCount;
	
	@FindBy(xpath = "//*[@id=\"wid-id-0\"]/header/div/div/ul[2]/li[1]")
	WebElement btn_pageFirst;
	
	@FindBy(xpath = "//*[@id=\"wid-id-0\"]/header/div/div/ul[2]/li[2]")
	WebElement btn_pagePrevious;
	
	@FindBy(xpath = "//*[@id=\"wid-id-0\"]/header/div/div/ul[2]/li[4]")
	WebElement btn_pageNext;

	@FindBy(xpath = "//*[@id=\"wid-id-0\"]/header/div/div/ul[2]/li[5]")
	WebElement btn_pageLast;
	
	@FindBy(id = "listingsPerPage")
	WebElement listPerPage;
	
	@FindBy(id = "bot2-Msg1")
	WebElement btn_accpetAlertMsg;
	
	@FindBy(id="errorContent")
	WebElement txt_alertmsg;
	
	/**
	 * Global Search
	 */
	@FindBy(xpath = "//*[@id=\"filter-form\"]/fieldset/div/section[1]/label[2]/input")
	WebElement txt_globalSearch;
	
	@FindBy(xpath = "//*[@id=\"filter-form\"]/fieldset/div/section[2]/div/button[1]")
	WebElement btn_go;
	
	/**
	 * Advanced Search
	 */
	@FindBy(xpath = "//*[@id=\"advFilter\"]/fieldset[2]/div/section/button[1]")
	WebElement btn_search;
	
	@FindBy(xpath= "//*[@id=\"advFilter\"]/fieldset[2]/div/section/button[2]")
	WebElement btn_clear;
	
	@FindBy(xpath = "//*[@id=\"advFilter\"]/fieldset[2]/div/section/button[3]")
	WebElement btn_advcancel;
	
	/**
	 * This method used to click create button
	 */
	public void clickCreatebutton() {
		try {
			//inAction.waitForElementToBeClickable(driver, btn_create);
			inAction.buttonClick(driver, btn_create, 
					"Click button : btn_create");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method used to click create button
	 */
	public void clickCreateOrUpdatebutton() {
		try {
			//inAction.waitForElementToBeClickable(driver, btn_createorupdate);
			inAction.buttonClick(driver, btn_createorupdate, 
					"Click button : btn_createorupdate");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method used to get the total no of pages in the table
	 * 
	 * @return integer value
	 */
	public int getTotalNumberOfPages(){
		String number = pageCount.getText().replaceAll("/", "").trim();
		int result = Integer.parseInt(number);
		return result;
	}
	
	/**
	 * This method used get the alert message text
	 * 
	 * @return alert message
	 */
	public String alertMessage() {
		//inAction.waitForVisibilityOfElement(driver, txt_alertmsg);
		String alertMessage = txt_alertmsg.getText();
		return alertMessage;
	}
	
	/**
	 * This method used to click the delete button in the view screen
	 */
	public void clickDeleteButton(){
		try {
			inAction.waitForElementToBeClickable(driver, btn_viewdelete);
			inAction.buttonClick(driver, btn_viewdelete,
					"Click button : btn_deleteclick");
			inAction.waitForElementToBeClickable(driver, btn_viewdelete);
			inAction.buttonClick(driver, btn_accpetAlertMsg, 
					"Click Yes button : btn_accpetAlertMsg");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method used to click the edit button in the view screen
	 */
	public void clickEditButton(){
		try {
			inAction.waitForElementToBeClickable(driver, btn_viewedit);
			inAction.buttonClick(driver, btn_viewedit,
					"Click button : btn_viewedit");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method used to click the entered value in the table 
	 * @param sValue
	 */
	public void clickValue(String sValue) {
		try {
			System.out.println("#@@@@@@@@@@@@@@@@$" + getTotalNumberOfPages());
			aa:
			for (int i = 1; i <= getTotalNumberOfPages(); i++) {
				WebElement htmltable = driver.findElement(By.
						xpath("//*[@id='filterSlider']/div/div/form[3]/div/div/div/div[2]/table/tbody"));
				List<WebElement> rows = htmltable.findElements(By.tagName("tr"));
				Thread.sleep(10000);
				for (WebElement rowElement : rows){
					Thread.sleep(10000);
					List<WebElement> columns = rowElement.findElements(By
						.tagName("td"));
					Thread.sleep(10000);
			
					for (WebElement colElement : columns){
						System.out.println("%%%%%%%%%%%%%%%%%%" + colElement.getText());
						Thread.sleep(1000);
						if (colElement.getText().equalsIgnoreCase(sValue)){
							Thread.sleep(1000);
							rowElement.click();
							break aa;
						}
					}
					btn_pageNext.click();
					Thread.sleep(5000);
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method used to click next button in the table
	 */
	public void clickNextButton() {
		try {
			inAction.waitForElementToBeClickable(driver, btn_pageNext);
			inAction.buttonClick(driver, btn_pageNext,
					"Click Yes button : btn_pageNext");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method used to click previous button in the table
	 */
	public void clickPreviousButton() {
		try {
			inAction.waitForElementToBeClickable(driver, btn_pagePrevious);
			inAction.buttonClick(driver, btn_pagePrevious,
					"Click Yes button : btn_pagePrevious");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method used to click Last button in the table
	 */
	public void clickLastButton() {
		try {
			inAction.waitForElementToBeClickable(driver, btn_pageLast);
			inAction.buttonClick(driver, btn_pageLast,
					"Click Yes button : btn_pageLast");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method used to click first button in the table
	 */
	public void clickFirstButton() {
		try {
			inAction.waitForElementToBeClickable(driver, btn_pageFirst);
			inAction.buttonClick(driver, btn_pageFirst,
					"Click Yes button : btn_pageFirst");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method used to select the list page count
	 * 
	 * @param sListCount
	 */
	public void selectPerPageCount(String sListCount) {
		try {
			inAction.selectItemFromDropdown(driver, listPerPage, sListCount, 
					"Select list per page count : listPerPage");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method used to perform global search
	 * 
	 * @param sValue
	 */
	public void globalSearch(String sValue) {
		try {

			inAction.waitForVisibilityOfElement(driver, txt_globalSearch);
			inAction.inputText(driver, txt_globalSearch, sValue,
					"Enter sValue:  + sValue");
			inAction.waitForElementToBeClickable(driver, btn_go);
			inAction.buttonClick(driver, btn_go,
					"Click button : btn_go");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
