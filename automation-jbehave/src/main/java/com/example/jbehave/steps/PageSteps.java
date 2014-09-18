package com.example.jbehave.steps;

import junit.framework.Assert;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.stereotype.Component;

import com.example.jbehave.pages.PageFactory;
import com.example.jbehave.pages.impl.ContactFormPageImpl;

@Component("pageSteps")
public class PageSteps {
    
    private ContactFormPageImpl contactForm; 
       
    Log logger = LogFactory.getLog(PageSteps.class);

    public PageSteps(PageFactory pageFactory){
    	contactForm = pageFactory.newContactForm();
    }
    
    @BeforeScenario
    public void iniConfig(){
    	logger.info("init config");
    }
    
    @Given("I'm on gimepmobile.com in the contact form")
    public void homeGooglePage(){
    	contactForm.go();
    }
    
    @When(value = "I submit the contact form with $firstName, $lastName, $email and $comments")
    public void sendContactForm(String firstName, String lastName, String email, String comments){
    	contactForm.submitContactForm(firstName, lastName, email, comments);
    }
    
    @Then("The success message is $Message")
    @Alias("results will be displayed in the contact form page")
    public void thereSomeSearchResults(String message) {
        Assert.assertTrue(contactForm.getMessage().startsWith(message));
    }
   
}
