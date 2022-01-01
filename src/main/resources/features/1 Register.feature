Feature: Account Register

Scenario: Testing Account Register
	Given User go to the Website
	When User click My Account button
	And User input username email password and click register
	Then User go to Login page