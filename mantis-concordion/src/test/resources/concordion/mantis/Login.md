# Login Feature

The application require user to sign-in in order to report new bugs or manage existing ones.

### [Successful login](- "Successful login")

The [administrator](- "#username") user logs-in by typing "[root](- "#password")" as password and
[submits credentials](- "loginWithCredentials(#username, #password)") in order to reach the dashboard page.

### [Unsuccessful login](- "Unsuccessful login")

The [administrator](- "#username") user logs-in by typing "[test](- "#password")" as password and
[submits credentials](- "loginWithCredentials(#username, #password)") in order to reach the dashboard page. 
This time the user will be [provided with an error message](- "c:assert-true=theUserIsProvidedWithAErrorMessage()") since
the password is incorrect.