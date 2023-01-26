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
Feature: Currency conversion with GET API
  I want to use this template for my feature file

  @tag1
  Scenario: /v2/tools/price-conversion Guatemalan Quetza to British pounds API validation
    Given All query parameters assigned to parameterPojoClass
    When User makes call to price-conversion api
    Then Input currency is changed to GBP currency
    
   @tag2
   Scenario: /v2/tools/price-conversion British pounds to Dogecoin API validation
   Given All query parameters assigned to parameterPojoClass
   When User pass converted GBP to API
   Then GBP currency is changed to Dogecoin
    

 
