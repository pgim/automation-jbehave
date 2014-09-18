package com.example.jbehave.steps;

import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.WebDriverException;
import org.springframework.stereotype.Component;

@Component("lifeCycleSteps")
public class LifeCycleSteps {

    private final WebDriverProvider webDriverProvider;

    public LifeCycleSteps(WebDriverProvider webDriverProvider) {
        this.webDriverProvider = webDriverProvider;
    }

    @BeforeScenario
    public void deleteCookie() {
        try {
            webDriverProvider.get().manage().deleteCookieNamed("uaid");
        } catch (WebDriverException e) {
            e.printStackTrace();
        }
    }
}
