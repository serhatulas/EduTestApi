package stepDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import static io.restassured.RestAssured.*;

public class Hooks {

    @Before
    public void setUp(){

        // baseURI="http://kps-qa.sytes.net:";//9001/api";
    }

    @After
    public void teardown(){
        reset();
    }
}
