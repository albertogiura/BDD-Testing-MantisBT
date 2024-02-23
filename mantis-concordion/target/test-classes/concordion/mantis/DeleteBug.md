# Delete Bug Feature

The application allows users to delete previously reported bug reports.

### [Per example setup](- "Background")
The user identify a bug with the following characteristics: it occurs on a [random](- "#reproducibility") basis, it 
is believed to be a [minor](- "#severity") issue, so its priority level will be set to [low](- "#priority"). 
He chooses "[New issue to be deleted](- "#summary")" as summary and "[I'm just a 'before' example](- "#description")" 
as description. The user [reports](- "createNewBug(#reproducibility, #severity, #priority, #summary, #description)") 
this bug using the report issue feature of the application.

### [Delete the latest reported issue](- "Delete the latest reported issue")

The [user](- "authenticateDefaultUser()") wants to delete the most recent issue report. He is able to look for the very 
latest bug report for a project named 
"[test](- "?=getCurrentProjectName()")" by [reaching the issues page](- "theUserReachesTheIssuesPage()"), looking at 
the very first row of reported bug table to [collect its ID](- "picksTheMostRecentBug()") and then using it to launch a 
search. Once he is provided with the issue detail page for that bug, the user 
[chooses to delete it](- "choosesToDeleteTheBugReport()").