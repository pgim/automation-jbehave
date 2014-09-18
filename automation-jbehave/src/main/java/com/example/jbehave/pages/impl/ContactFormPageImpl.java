package com.example.jbehave.pages.impl;

import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;

import com.example.jbehave.pages.ContactFormPage;

public class ContactFormPageImpl extends BaseImplPage implements ContactFormPage {

	private static final By INPUT_FIRST_NAME = By.id("input-443138284781667233");
	private static final By INPUT_LAST_NAME = By.id("input-443138284781667233-1");
	private static final By INPUT_EMAIL = By.id("input-651478021189180441");
	private static final By INPUT_COMMENTS = By.id("input-611364065981515057");
	private static final By ID_SUBMIT = By.cssSelector("#form-851191180248929463 > div:nth-child(3) > a > span");
	private static final By DIV_MESSAGE = By.id("851191180248929463-msg");
	
	public ContactFormPageImpl(WebDriverProvider driverProvider) {
		super(driverProvider);		
	}

	public void go(){
		get("http://gimepmobile.weebly.com/contact.html");
	}
	
	public void submitContactForm(String firstName, String lastName, String email, String comments){
		input(INPUT_FIRST_NAME).sendKeys(firstName);	
		input(INPUT_LAST_NAME).sendKeys(lastName);
		input(INPUT_EMAIL).sendKeys(email);
		textarea(INPUT_COMMENTS).sendKeys(comments);
		waitForDisplayedElement(ID_SUBMIT).click();
	}
	
	public String getMessage(){
		return waitForDisplayedElement(DIV_MESSAGE).getText().toString();
	}
	
}
