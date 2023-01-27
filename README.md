# CurrencyConversion
1. Project is structured using Cucumber Design pattern
2. All the required execution files are located under CurrencyConversio/src/test/java
3. Reports are present under src/test/resources/Reports directory with file name index.html
4. Use TestNgRunner file to execute the project
5. src/test/java has four main packages 
-> Features: Having CurrencyConversion.feature file
-> StepDefination: Have implementions for two scenarios -> Guatemalan Quetzal to GBP conversion & GBP to Dogecoin conversion
-> TestRunner: It has project configuration i.e JUnit runner integration, feature file and step defination file markings
6. Utilities: It has two classes 
-> ParameterPojoClass to set and retrive query parameters required for API call
-> Utilities it acts as implemention methods for Function interface to return converted currencies
7. Project is java V1.8 based so have used Function inerface to provide response from api, to fetch converted values and return it back
