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

    @Step("Given Phileas is planning the trip")
    public void given_someone_is_planning_the_trip() {
        tripPlannerPage.open();
    }

    @Step("When he executes a trip plan from {0} to {1}")
    public void when_he_excutes_a_trip_from_A_to_B(String fromStation, String toStation) {
        tripPlannerPage.searchFromStation(fromStation);
        tripPlannerPage.searchToStation(toStation);
        tripPlannerPage.clickGoButton();
    }

    @Step("Then a list of trips should be provided")
    public void then_a_list_of_trips_should_be_provided() {
        assertTrue(tripPlannerPage.resultListIsDisplayed());

    }



}
