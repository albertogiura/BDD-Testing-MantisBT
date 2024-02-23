Feature: Login
  Scenario: Successful login
    Given a user that opens the login page
    When the user fills the fields with username "administrator" and password "stage"
    Then the user reaches the dashboard page

  Scenario: Unsuccessful login
    Given a user that opens the login page
    When the user fills the fields with username "admin" and password "prova"
    Then the user is provided with a error message