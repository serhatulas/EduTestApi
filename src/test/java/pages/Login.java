package pages;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.ConfigurationReader;

import java.util.HashMap;
import java.util.Map;

public class Login {

    static Response response;
     static String expectedRole="";

   static public void loginWithValidCredentials(String role){
        String email="";
        expectedRole=role;
        String password=ConfigurationReader.get("passwordCommon");
        String iamPort= ConfigurationReader.get("iamPort");
        switch (role){
            case "SUPER_ADMIN":
            email= ConfigurationReader.get("superadminEmail");
            break;
            case "EDITOR":
                email=ConfigurationReader.get("editorEmail");
                break;
            case "MODERATOR":
                email=ConfigurationReader.get("moderatorEmail");
                break;
            case "EXPERT":
                email=ConfigurationReader.get("expertEmail");
                break;
            case "SCHOOL_ADMIN":
                email=ConfigurationReader.get("schoolAdminEmail");
                break;
            case "SALESMAN":
                email=ConfigurationReader.get("salesmanEmail");
                break;
            case "STUDENT":
                email=ConfigurationReader.get("studentEmail");
                break;
        }

        Map<String,Object> loginBody= new HashMap<>();
        loginBody.put("email",email);
        loginBody.put("password",password);


        response=given().contentType(ContentType.JSON).body(loginBody).log().all().
                            when().post("http://kps-qa.sytes.net:9001/api/auth/login").prettyPeek();
    }

    public void verifyUserLogin(){


        String actualRole= response.jsonPath().getString("data.roles[0]");
        Assert.assertEquals(200,response.statusCode());
        Assert.assertEquals("Roles didn't match",expectedRole,actualRole);

    }


    public static String token(String role){

        loginWithValidCredentials(role);

        String token="Bearer "+ response.jsonPath().getString("data.token");
        return token;


    }



}
