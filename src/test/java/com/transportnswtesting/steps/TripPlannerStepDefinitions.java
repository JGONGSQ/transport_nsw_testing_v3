package com.transportnswtesting.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

/**
 * Created by daddyspro on 24/2/18.
 */
public class TripPlannerStepDefinitions {

    @Steps
    TripPlannerSteps tripPlannerSteps;

    @Given("Phileas is planning a trip")
    public void planningTheTrip(){
        tripPlannerSteps.planningTheTrip();
    }

    @When("he executes a trip plan from \"(.*)\" to \"(.*)\"")
    public void executesFromAToB(String fromStation, String toStation){
        tripPlannerSteps.executesFromAToB(fromStation, toStation);
    }

    @Then("a list of trips should be provided")
    public void listOfTripsShouldBeProvided() {
        tripPlannerSteps.listOfTripsShouldBeProvided();
    }
}
