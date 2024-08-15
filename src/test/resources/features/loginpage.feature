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
Feature: Login Functionality For Air Canada
  As a user one should be able to login successfully
  Customer should be able to login to get additional feature available
  Enable customer to reset password as well as create new account
  
  Background:
  Given I am on the login page of Air Canada

  @tag1
  Scenario: Error if try to login using Invalid aeroplan number or email
    Given I have entered invalid "<aeronumberorEmail>"
    When I move to password block to enter password
    Then I should see error message indicating "<error_message>"
    
       Examples: 
      | aeronumberorEmail  | error_message  |
      | hagsdhashfghagsff |  Please enter a valid Aeroplan number or email. |
      | 1221548365 |  Please enter a valid Aeroplan number or email. |
