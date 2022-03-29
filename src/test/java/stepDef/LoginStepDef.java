package stepDef;

import io.cucumber.java.en.*;
import pages.Login;

public class LoginStepDef {

    Login login=new Login();

    @Given("make a request for user {string}")
    public void make_a_request_for_user(String role) {

        Login.loginWithValidCredentials(role);

    }
    @When("verify if the login successful")
    public void verify_if_the_login_successful() {

        login.verifyUserLogin();
        System.out.println("SUPERADMINTOKEN  --> "+Login.token("SUPER_ADMIN"));
    }

}
