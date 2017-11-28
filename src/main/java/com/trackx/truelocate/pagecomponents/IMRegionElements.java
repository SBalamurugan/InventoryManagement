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
	 * Edit Elements
	 */
	
	@FindBy(xpath = "//*[@id=\"wid-id-0\"]/header/div/div/ul[2]/li[4]")
	WebElement btn_pageNext;
	
	@FindBy(className = "pageNo")
	WebElement pageCount;
	
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
	 * This method used to create/edit Region
	 * 
	 * @param sCode
	 * @param sName 
	 */
	public void enterRegionInfo(String sCode, String sName) {
		try {
			inAction.waitForVisibilityOfElement(driver, txt_code);
			inAction.inputText(driver, txt_code, sCode,
					"Enter sCode : " + sCode);
			inAction.waitForVisibilityOfElement(driver, txt_name);
			inAction.inputText(driver, txt_name, sName,
					"Enter sFirstname : " + sName);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method used to fill edit Region feilds
	 * 
	 * @param sCode
	 * @param sName 
	 */
	
public void editsite(String sValue) {
	try {

		WebElement htmltable = driver.findElement(By.xpath("//*[@id='filterSlider']/div/div/form[3]/div/div/div/div[2]/table/tbody"));

		List<WebElement> rows = htmltable.findElements(By.tagName("tr"));
		
		Thread.sleep(1000);

		System.out.println("Number of rows:" + rows.size());

		for (WebElement rowElement : rows)

		{
			List<WebElement> columns = rowElement.findElements(By.tagName("td"));

			for (WebElement colElement : columns)

			{
		    if (colElement.getText().equalsIgnoreCase(sValue))
				
			{
			System.out.println("******* Value Found*********** ");
					
			System.out.println(colElement.getText() + "******* element value*********** ");
					
			Thread.sleep(1000);
					
			rowElement.click();
					
			Thread.sleep(1000);
						
			
			}
			}
		}
	}
			catch (Exception e) {
				e.printStackTrace();
			}
		}

public void clickValue(WebDriver driver, String sValue) {
	
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
 * This method used to get the total no of pages in the table
 * 
 * @return integer value
 */
public int getTotalNumberOfPages(){
	String number = pageCount.getText().replaceAll("/", "").trim();
	int result = Integer.parseInt(number);
	return result;
}	
}		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	

