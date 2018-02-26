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
    private String response;

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
    public void searchStation(String stationName) {
        /**
         * @param stationName, the name of station to search
         */
        String url = String.format(base_url, stationName);
        response = RestAssured.when().get(url).asString();
        stopName = from(response).get("locations.name");
        modes = from(response).get("locations.modes");
    }

    @Step
    public void foundStation(String realStationName) {
        /**
         * @param realStationName, the name of the station name returned from REST api.
         */
        assertEquals(realStationName, stopName.get(0));
    }

    @Step
    public void travelModeIsMoreThanOne() {
        assertTrue(modes.get(0).size() > 1);
    }

}
