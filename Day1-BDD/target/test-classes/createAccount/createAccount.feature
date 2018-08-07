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
Feature: Create New Account
   Create new account for the valid customer details

  Scenario: For valid customer create new account
    Given For customer details
    When Valid customer
    And valid openingBalance
    Then create new account
    
  Scenario: Find account details
  	Find account details for the given account number
    Given Account Number
    When Valid Account Number
    Then Find Account Details
    
 Scenario: Withdraw Amount from Account
  Find account details and withdraw amount
  	Given Account number 1 and amount 1000
  	When Find account and do Withdraw
  	Then update the account details
  
