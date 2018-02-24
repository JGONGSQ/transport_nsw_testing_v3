package com.transportnswtesting.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

/**
 * Created by daddyspro on 24/2/18.
 */
public class StopFinderStepDefinitions {
    @Steps
    StopFinderRESTSteps stopFinderSteps;

    @Given("Phileas is looking for a stop")
    public void lookingForStop() {
        stopFinderSteps.lookingForStop();
    }

    @When("he searches for \"(.*)\"")
    public void searchForStop(String stationName) {
        stopFinderSteps.searchStation(stationName);
    }

    @Then("a stop named \"(.*)\" is found")
    public void foundStation(String realStationName){
        stopFinderSteps.foundStation(realStationName);
    }

    @And("the stop provides more than one mode of transport")
    public void travelModeIsMoreThanOne() {
        stopFinderSteps.travelModeIsMoreThanOne();
    }

}
