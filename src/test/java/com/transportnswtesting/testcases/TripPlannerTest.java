package com.transportnswtesting.testcases;

import com.transportnswtesting.pages.TripPlannerPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertTrue;

/**
 Created by daddyspro on 20/2/18.
 */
public class TripPlannerTest {

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

        // initial the page and input data
        TripPlannerPage page = new TripPlannerPage(driver);
        page.searchStation("From","North Sydney Station");
        page.searchStation("To", "Town Hall Station");

        // click the go button
        page.goButton.click();

        // make the list of results are presented
        assertTrue(page.resultList.isDisplayed());

    }
}
