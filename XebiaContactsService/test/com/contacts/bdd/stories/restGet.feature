Rest Requests story

Narrative:
In order to test rest api for all contacts list
As a development team
I want to use Behaviour-Driven Development
					 
Scenario: Get request contacts if no contacts exist
Given a url http://localhost:14569/XebiaContactsService/api/contacts/
When I request the get method for all contacts
Then I should obtain the following JSON message <expectedResult>
Examples:
| expectedResult          |
| No Contacts found in Memory. |