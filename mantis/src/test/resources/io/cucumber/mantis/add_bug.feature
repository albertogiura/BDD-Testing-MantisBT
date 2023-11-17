Feature: Add bug

  Scenario: Report an issue for a project
    Given a logged in user
    And an existing project named "test"
    When the user reaches the bug report page
    And chooses "sometimes" as "Reproducibility"
    And sets "major" as "Severity"
    And chooses "normal" as "Priority"
    And writes "Not working" as Summary
    And writes "A generic error is showed" in the description field
    Then a new bug is registered for that project