package stepDef;

import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pages.Login;
import pages.Salesman;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class SalesmanStepDef {
    static Response response;
    Salesman salesman =new Salesman();
    Login login=new Login();
    @Given("make a request for user")
    public void make_a_request_for_user() {
        Map<String,Object> loginBody= new HashMap<>();
        loginBody.put("email","salesman4@example.com");
        loginBody.put("firstName","John");
        loginBody.put("lastName","Ben");
        loginBody.put("mobile","123456");
        loginBody.put("password","Test123456!");

        response=given().log().all().contentType(ContentType.JSON).body(loginBody)
                .headers("Authorization", login.token("SUPER_ADMIN")).
                when().post("http://kps-qa.sytes.net:9002/api/salesman").prettyPeek();
    }
    @When("verify if the new member created")
    public void verify_if_the_new_member_created() {
       // salesman.verifyUserSalesman();
        System.out.println("RESPONSE STATUS = "+response.statusCode());


    }
}
