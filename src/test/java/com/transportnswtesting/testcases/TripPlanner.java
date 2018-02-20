package com.transportnswtesting.testcases;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

/**
 Created by daddyspro on 20/2/18.
 */
public class TripPlanner {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void canListTrips() {
        // get the page
        driver.get("https://transportnsw.info/trip");

        // input data
        WebElement inputFrom = driver.findElement(By.id("search-input-From"));
        inputFrom.sendKeys("North Sydney Station");
        inputFrom.click();

        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(By.id("suggestion-From-0")).isDisplayed();
            }
        });

        WebElement originDropdown = driver.findElement(By.id("suggestion-From-0"));
        originDropdown.click();

        WebElement inputTo = driver.findElement(By.id("search-input-To"));
        inputTo.sendKeys("Town Hall Station");
        inputTo.click();

        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(By.id("suggestion-To-0")).isDisplayed();
            }
        });

        WebElement destinationDropdown = driver.findElement(By.id("suggestion-To-0"));
        destinationDropdown.click();

        // click the go button
        WebElement goButton = driver.findElement(By.id("search-button"));
        goButton.click();

        // make the list of results are presented
        WebElement tripList = driver.findElement(By.id("tp-result-list"));

        assertTrue(tripList.isDisplayed());

    }
}
