Feature: Delete an existing issue report

  Background:
    Given a logged in user
    And an existing project named "test"
    When the user reaches the bug report page
    And chooses "sometimes" as "reproducibility" for the issue
    And chooses "major" as "severity" for the issue
    And chooses "normal" as "priority" for the issue
    And writes a title for the problem as "Issue to be removed"
    And writes some details about the issue as "Bye bye"
    Then a new bug is registered for that project

  Scenario: Successfully delete last reported issue
    Given an existing project named "test"
    When the user reaches the issues page
    And picks the most recent bug
    And chooses to delete the bug report
    Then the stored bug id should not work anymore
