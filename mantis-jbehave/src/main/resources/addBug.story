Narrative:
As a user
I want to be able to report a new bug
so that I can record and handle existing issues

Lifecycle:
Before:
Scope: SCENARIO
Given a logged in user

Scenario: add bug
Given an existing project named test
When the user reaches the bug report page
When chooses <Reproducibility> as reproducibility for the issue
When chooses <Severity> as severity for the issue
When chooses <Priority> as priority for the issue
When writes a title for the problem as <Summary>
When writes some details about the issue as <Description>
Then a new bug is registered for that project

Examples:
| Reproducibility  | Severity | Priority | Summary | Description |
| sometimes       | major    | normal  | New issue 1 | A generic error is showed |
| always          | crash    | urgent  | New issue 2 | A crash error |
| random          | minor    | low    | New issue 3 | Happens randomly |