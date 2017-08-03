#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios 
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Lieferando Search Functionality
	I want to see HomePage and use the Search functionality

Scenario: Check user sees the HomePage
Given User opens the Lieferando website
Then he should see HomePage with Lieferando button text "Lieferando.de"
And he should see Search bar
And he should see Show button
And the driver is closed

Scenario: Check user sees the auto-suggestion for address
Given User opens the Lieferando website
When he enters the address "Alex" in the search bar
Then he should see a suggestion box
And  box should contain suggestions related to "Alex"
And  the box should contains suggestions between 1 and 5
And  the driver is closed

Scenario: Check user sees the auto-suggestions for post code
Given User opens the Lieferando website
When he enters the address "104" in the search bar
And he should see a suggestion box
Then  box should contain suggestions related to "104"
And  the box should contains suggestions between 1 and 5
And  the driver is closed

Scenario: Check user can search address and see the restaurants
Given User opens the Lieferando website
When he enters the address "Alexa" in the search bar
And he should see a suggestion box
And  he selects a value from the suggestion box
Then he should be redirected to search results page
And the driver is closed

Scenario: Check user can search postcode and see the restaurants
Given User opens the Lieferando website
When he enters the address "104" in the search bar
And he should see a suggestion box
And  he selects a value from the suggestion box
Then he should be redirected to search results page
And the driver is closed


Scenario: Check the validation for empty search
Given User opens the Lieferando website
And  he clicks the Show button
Then he should see a validation message
And the driver is closed

Scenario: Check the validation for invalid post code
Given User opens the Lieferando website
And  he enters post code "11987"
And  he selects a value from the suggestion box
Then he should see a validation message 
And  the driver is closed