package com.transportnswtesting.testcases;

import com.transportnswtesting.steps.TripPlannerSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 Created by daddyspro on 23/2/18.
 */

@RunWith(SerenityRunner.class)
public class TripPlannerTest {

    @Managed
    WebDriver driver;

    @Steps
    TripPlannerSteps plannerSteps;

    @Test
    public void canListTrips() {
        // GIVEN
        plannerSteps.planningTheTrip();

        // WHEN
        plannerSteps.excutesFromAToB("North Sydney Station", "Town Hall Station");

        // THEN
        plannerSteps.listOfTripsShouldBeProvided();
    }
}
