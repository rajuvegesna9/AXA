Feature: Home Insurance Quotes

Scenario: Retrieve a Quote
Given User navigates to the AXA Home Page
And User logs in with EmailAddress and Password
When User retrieves the saved quote 
Then the saved quote details are displayed correctly

Scenario: Get a Quote
Given User navigates to the AXA Home Page
When User generates Home Insurance Quote
Then Home Insurance Quote details are successfully displayed