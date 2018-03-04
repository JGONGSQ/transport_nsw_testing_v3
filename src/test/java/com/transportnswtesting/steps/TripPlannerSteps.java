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

    @Step
    public void planningTheTrip() {
        tripPlannerPage.open();
    }


    /**
     * @param fromStation The station name for "From" Field
     * @param toStation The station name for "To" Field
     */
    @Step
    public void executesFromAToB(String fromStation, String toStation) {

        tripPlannerPage.searchFromStation(fromStation);
        tripPlannerPage.searchToStation(toStation);
        tripPlannerPage.clickGoButton();
    }

    @Step
    public void listOfTripsShouldBeProvided() {
        assertTrue(tripPlannerPage.resultListIsDisplayed());
    }



}
