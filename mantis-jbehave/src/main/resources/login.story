Narrative:
As a user
I want to login into the application
So that I can report a new bug or manage existing ones

Scenario: Successful login
Given a user that opens the login page
When the user fills the fields with username administrator and password stage
Then the user reaches the dashboard page

Scenario: Unsuccessful login
Given a user that opens the login page
When the user fills the fields with username admin and password prova
Then the user is provided with a error message