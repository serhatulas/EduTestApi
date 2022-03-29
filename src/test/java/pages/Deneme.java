package pages;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.ConfigurationReader;

public class Deneme {

    @Test
    public void portDeneme(){
        String url = ConfigurationReader.get("baseURI")+ConfigurationReader.get("testPort");
        Response response=given().contentType(ContentType.JSON).get(url).prettyPeek();
    }


    public void Deneme2(){

        Response response= given().contentType(ContentType.JSON).headers("Authorization",Login.token("TEACHER")).log().all().when().put();


    }
}
