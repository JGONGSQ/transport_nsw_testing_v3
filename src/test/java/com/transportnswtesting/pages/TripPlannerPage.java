/**
    Created by daddyspro on 20/2/18.
 */

package com.transportnswtesting.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


@DefaultUrl("https://transportnsw.info/trip")
public class TripPlannerPage extends PageObject {

    @FindBy(id = "search-input-From")
    private WebElement inputFrom;

    @FindBy(id = "search-input-To")
    private WebElement inputTo;

    @FindBy(id = "search-button")
    private WebElement goButton;

    @FindBy(id = "tp-result-list")
    private WebElement resultList;

    private WebElement inputBox;

    private String dropDownXpath = "//*[contains(text(), 'stationName')]";

    public TripPlannerPage(WebDriver driver) {
        super(driver);
    }

    public void clickGoButton() {
        goButton.click();
    }

    public Boolean resultListIsDisplayed() {
        return resultList.isDisplayed();
    }

    public void searchFromStation(String fromStation) {
        /**
         * @param fromStation: the station name put in the From station input box, e.g. North Sydney Station
         */
        searchStation("From", fromStation);
    }

    public void searchToStation(String toStation) {
        /**
         * @param toStation: the station name put in the To station input box, e.g. Town Hall Station
         */
        searchStation("To", toStation);
    }

    private void searchStation(String action, String stationName) {
        /**
         * @param action: The search action to perform for the location of input box.
         * @param stationName: the station name put in the station input box, e.g. Town Hall Station
         */
        if (action.equals("From")) {
            inputBox = inputFrom;

        } else if (action.equals("To")) {
            inputBox = inputTo;
        }

        inputBox.sendKeys(stationName);
        inputBox.click();

        WebElement dropdown = find(By.xpath(dropDownXpath.replace("stationName", stationName)));
        waitFor(ExpectedConditions.visibilityOf(dropdown));
        dropdown.click();


    }


}
