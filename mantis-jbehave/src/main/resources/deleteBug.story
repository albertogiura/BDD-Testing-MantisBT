Narrative:
As a user
I want to be able to delete an existing bug.

Lifecycle:
Before:
Scope: SCENARIO
Given a logged in user
Given an existing project named test
When the user reaches the bug report page
When chooses sometimes as reproducibility for the issue
When chooses major as severity for the issue
When chooses normal as priority for the issue
When writes a title for the problem as Issue to be removed
When writes some details about the issue as This will be deleted soon
Then a new bug is registered for that project

Scenario: Delete the latest bug report
Given an existing project named test
When the user reaches the issues page
When picks the most recent bug
When chooses to delete the bug report
Then the stored bug id should not work anymore

