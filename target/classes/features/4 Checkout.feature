Feature: Checkout

Scenario: Testing Checkout
	When User click icon cart and click proceed to checkout
	And User input billing details and click place order
	Then User go to order details page