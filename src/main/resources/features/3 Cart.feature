Feature: Add to Cart

Scenario: Testing Add to Cart Shoes
	When User click search type keyword shoes and press enter
	And User click compare click select option choose color size and click add to cart
	Then User go to search shoes page

Scenario: Testing Add to Cart Glass
	When User click search type keyword glass and press enter
	And User click product choose color size and click add to cart
	Then User go to search glass page