# Search Bug Feature

The application provides support for retrieving details about a bug report knowing its ID.

### [Look for the latest reported issue](- "Look for the latest reported issue")

The [user](- "authenticateDefaultUser()") is able to look for the most recent issue report for a project named 
"[test](- "?=getCurrentProjectName()")" by [reaching the issues page](- "theUserReachesTheIssuesPage()"), looking at 
the very first row of reported bug table to [collect its ID](- "picksTheMostRecentBug()") and then using it to launch a 
search.