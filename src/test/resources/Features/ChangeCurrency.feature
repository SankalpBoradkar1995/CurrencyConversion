
Feature: Currency conversion with GET API


 
  Scenario: /v2/tools/price-conversion Guatemalan Quetza to British pounds API validation
   Given All query parameters assigned to parameterPojoClass
    When User makes call to price-conversion api
    Then Input currency is changed to GBP currency
    
    Scenario: /v2/tools/price-conversion British pounds to Dogecoin API validation
   Given All query parameters assigned to parameterPojoClass
   When User pass converted GBP to API
   Then GBP currency is changed to Dogecoin
   
 
   

 
