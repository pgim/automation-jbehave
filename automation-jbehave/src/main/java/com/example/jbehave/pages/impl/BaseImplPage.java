package com.example.jbehave.pages.impl;

import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseImplPage extends FluentWebDriverPage {

    private static final long WEB_DRIVER_WAIT_TIME = 30;

    public BaseImplPage(WebDriverProvider driverProvider) {
		super(driverProvider);
	}
	
	protected WebElement waitForDisplayedElement(final By by) {
        WebDriverWait wait = new WebDriverWait(getDriverProvider().get(), WEB_DRIVER_WAIT_TIME);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
        return element;
    }

}
