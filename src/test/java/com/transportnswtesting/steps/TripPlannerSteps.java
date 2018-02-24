package com.transportnswtesting.steps;

import com.transportnswtesting.pages.TripPlannerPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.junit.Assert.assertTrue;

/**
  Created by daddyspro on 23/2/18.
 */

public class TripPlannerSteps extends ScenarioSteps {

    private TripPlannerPage tripPlannerPage;

//    @Step("Given Phileas is planning the trip")
    @Step
    public void planningTheTrip() {
        tripPlannerPage.open();
    }

//    @Step("When he executes a trip plan from {0} to {1}")
    @Step
    public void excutesFromAToB(String fromStation, String toStation) {
        tripPlannerPage.searchFromStation(fromStation);
        tripPlannerPage.searchToStation(toStation);
        tripPlannerPage.clickGoButton();
    }

//    @Step("Then a list of trips should be provided")
    @Step
    public void listOfTripsShouldBeProvided() {
        assertTrue(tripPlannerPage.resultListIsDisplayed());

    }



}
