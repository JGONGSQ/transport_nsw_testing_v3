package com.transportnswtesting.steps;

import com.transportnswtesting.pages.TripPlannerPage;
import net.thucydides.core.annotations.Step;

/**
  Created by daddyspro on 23/2/18.
 */

public class TripPlannerSteps {

    private TripPlannerPage tripPlannerPage;

    @Step("Given Phileas is planning the trip")
    public void given_someone_is_planning_the_trip() {
        tripPlannerPage.open();

    }



}
