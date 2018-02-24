package com.transportnswtesting.testcases;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Created by daddyspro on 24/2/18.
 */

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features="src/test/resources/features/StopFinder.feature",
        glue = {"com.transportnswtesting.steps"}
)
public class StopFinderCucumberTest {}
