@search
Feature: Check car registraion on website
  Scenario: car registraion check base on numbers
    Given get the car registraion number from the input file
    When  search the registrion number using  input number
    Then  get the  registraion details  using number
    And  veriry the details correct or not
