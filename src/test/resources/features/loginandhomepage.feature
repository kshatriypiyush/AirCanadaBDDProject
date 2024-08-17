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

Feature: Login Functionality and Home Page Feature of Air Canada
  Customer should be able to see popular destinations
  Montreal is quite trending lets check it out
  Error for invalid Aeropal Number or Email
  Enable customer to reset password as well as create new account
  
  Scenario: Error if try to login using Invalid aeroplan number or email
  	Given I am on Air Canada Page
    When I have entered invalid "<username>"
    When I move to password block to enter password "<password>"
    Then I should see error message indicating "<error_msg>"
		
		Examples:
			| username 				 | password | error_msg                                      |
			| ajsvdhasvdasvdas | test1278	| Please enter a valid Aeroplan number or email. |
			| 587412536942asda | juasdfvw | Please enter a valid Aeroplan number or email. |

  Scenario: Navigate to Create Account Page
  	Given I am on Air Canada Page
  	When I have click on create a new account link
  	Then I should navigate to Create Account which has page title "Air Canada - Official website - Aeroplan - Enroll"

  Scenario: Navigate to Forgot Password Page
  	Given I am on Air Canada Page
  	When I have click on forgot your password
  	Then I should navigate to Forgot Password whose page title "Forgot Password"
 
 Scenario: Total Number of Routes and Partners under Book Drop Down
 		Given I am on Air Canada Page
  	When I click on Book Menu in Header
  	Then I should see 7 Routes and Partners under drop down menu
  

 Scenario: Total Number of Popular destinations under Book Drop Down
 		Given I am on Air Canada Page
  	When I click on Book Menu in Header
  	Then I should see 6 Popular destinations under drop down menu
  

 Scenario: Check if Montreal is under Popular Destinations List
 		Given I am on Air Canada Page
  	When I click on Book Menu in Header
  	Then I should see Montreal as Popular Destinations