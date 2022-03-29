Feature:Login

  @Login1
  Scenario: User should be able to login with valid credentials
    Given make a request for user "STUDENT"
    When verify if the login successful
