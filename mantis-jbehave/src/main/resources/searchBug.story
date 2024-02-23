Narrative:
As a user
I want to be able to look for a reported issue
So that I can check its status

Lifecycle:
Before:
Scope: SCENARIO
Given a logged in user

Scenario: Look for the most recent reported issue
Given an existing project named test
When the user reaches the issues page
And picks the most recent bug
Then the bug detail page for that issue is displayed

Scenario: Find an existing reported issue
Given an existing project named test
When I look for a bug with ID 0000003
Then the bug detail page for issue 0000003 is displayed
