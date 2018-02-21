package com.transportnswtesting.testcases;

import io.restassured.RestAssured;
import org.junit.Test;

import java.util.List;

import static io.restassured.path.json.JsonPath.from;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by daddyspro on 21/2/18.
 */
public class StopFinderRESTTest {

    private String base_url = "http://www.transportnsw.info/web/XML_STOPFINDER_REQUEST" +
            "?TfNSWSF=true" +
            "&language=en" +
            "&name_sf=%s" +
            "&outputFormat=rapidJSON" +
            "&type_sf=any" +
            "&version=10.2.2.48";

    @Test
    public void stopCouldBeFound() {
        // Formate the request url
        String url = String.format(base_url, "Wynyard Station");

        // get the response
        String response = RestAssured.get(url).asString();

        // read the response
        List<String> stopName = from(response).get("locations.name");
        List<List> modes = from(response).get("locations.modes");

        // compare
        assertEquals("Wynyard Station, Sydney", stopName.get(0));
        assertTrue(modes.get(0).size() > 1);

    }
}
