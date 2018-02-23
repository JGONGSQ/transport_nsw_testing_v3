/**
    Created by daddyspro on 20/2/18.
 */

package com.transportnswtesting.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TripPlannerPage extends PageObject {

    @FindBy(id = "search-input-From")
    private WebElement inputFrom;

    @FindBy(id = "search-input-To")
    private WebElement inputTo;

    @FindBy(id = "suggestion-From-0")
    private WebElement dropdownFrom;

    @FindBy(id = "suggestion-To-0")
    private WebElement dropdownTo;

    @FindBy(id = "search-button")
    public WebElement goButton;

    @FindBy(id = "tp-result-list")
    public WebElement resultList;

    private WebElement dropdown;
    private WebElement inputBox;

    public TripPlannerPage(WebDriver driver) {
        super(driver);
    }

    public void goToPage(){
        driver.get("https://transportnsw.info/trip");
    }

    public void searchStation(String action, String stationName) {
        if (action.equals("From")) {
            inputBox = inputFrom;
            dropdown = dropdownFrom;

        } else if (action.equals("To")) {
            inputBox = inputTo;
            dropdown = dropdownTo;
        }

        inputBox.sendKeys(stationName);
        inputBox.click();

//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.visibilityOf(dropdown));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(dropdown));

        dropdown.click();


    }


}
