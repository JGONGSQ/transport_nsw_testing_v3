package com.transportnswtesting.steps;

import io.restassured.RestAssured;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.List;

import static io.restassured.path.json.JsonPath.from;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by daddyspro on 24/2/18.
 */
public class StopFinderRESTSteps extends ScenarioSteps {

    private String base_url;
    private List<String> stopName;
    private List<List> modes;

    @Step
    public void lookingForStop() {
        base_url = "http://www.transportnsw.info/web/XML_STOPFINDER_REQUEST" +
                "?TfNSWSF=true" +
                "&language=en" +
                "&name_sf=%s" +
                "&outputFormat=rapidJSON" +
                "&type_sf=any" +
                "&version=10.2.2.48";
    }

    @Step
    public void searchStation(String staionName) {
        String url = String.format(base_url, staionName);
        String response = RestAssured.get(url).asString();
        stopName = from(response).get("locations.name");
        modes = from(response).get("locations.modes");
    }

    @Step
    public void foundStation(String realStationName) {
        assertEquals(realStationName, stopName.get(0));
    }

    @Step
    public void travelModeIsMoreThanOne() {
        assertTrue(modes.get(0).size() > 1);
    }

}
