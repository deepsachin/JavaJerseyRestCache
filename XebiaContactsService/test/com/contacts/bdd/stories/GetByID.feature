Rest Requests story for one item

Narrative:
In order to test rest api for single contact
As a development team
I want to use Behaviour-Driven Development

Scenario: Get requested contact by Invalid ID
Given a url with id http://localhost:14569/XebiaContactsService/api/contacts/123
When I request the get method for single contact
Then I should obtain the following JSON messag <expectedResult>
Examples:
| expectedResult          |
| Requested contact id: 1234 does not exist. |