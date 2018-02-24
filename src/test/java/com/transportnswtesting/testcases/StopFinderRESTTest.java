package com.transportnswtesting.testcases;

import com.transportnswtesting.steps.StopFinderRESTSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by daddyspro on 24/2/18.
 */

@RunWith(SerenityRunner.class)
public class StopFinderRESTTest {

    @Steps
    StopFinderRESTSteps stopFinderSteps;

    @Test
    public void canGetTheStopNameViaRESTAPI() {
        // Given
        stopFinderSteps.lookingForStop();

        // When
        stopFinderSteps.searchStation("Wynyard Station");

        // Then
        stopFinderSteps.foundStation("Wynyard Station, Sydney");

        // And
        stopFinderSteps.travelModeIsMoreThanOne();


    }

}
