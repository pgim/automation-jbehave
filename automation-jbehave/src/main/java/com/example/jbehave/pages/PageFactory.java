package com.example.jbehave.pages;

import org.jbehave.web.selenium.WebDriverProvider;

import com.example.jbehave.pages.impl.ContactFormPageImpl;

public class PageFactory {

    private final WebDriverProvider webDriverProvider;

    public PageFactory(WebDriverProvider webDriverProvider) {
        this.webDriverProvider = webDriverProvider;
    }
   
    public ContactFormPageImpl newContactForm(){
    	return new ContactFormPageImpl(webDriverProvider);
    }

}
