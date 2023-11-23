Feature: Add bug

  Scenario Outline: Report an issue for a project
    Given a logged in user
    And an existing project named "test"
    When the user reaches the bug report page
    And chooses <Reproducibility> as "reproducibility" for the issue
    And chooses <Severity> as "severity" for the issue
    And chooses <Priority> as "priority" for the issue
    And writes a title for the problem as <Summary>
    And writes some details about the issue as <Description>
    Then a new bug is registered for that project
    Examples:
      | Reproducibility  | Severity | Priority | Summary | Description |
      | "sometimes"       | "major"    | "normal"  | "New issue 1" | "A generic error is showed" |
      | "always"          | "crash"    | "urgent"  | "New issue 2" | "A crash error" |
      | "random"          | "minor"    | "low"     | "New issue 3" | "Happens randomly" |