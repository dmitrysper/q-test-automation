@web @login
Feature: Positive and negative login
  As a user of Heroku test app
  I want to able to log in with correct credentials and get meaningful message for incorrect
  So that only a valid user can access secure site area

  Background:
    Given I am on the "Start" page

  @positive_login
  Scenario: Positive login

    When I click on "Form Authentication" link
    Then I should see "Login" page

    When I enter correct user name
     And I enter correct password
     And I click on "Login" button
    Then I should see "Secure Area" page
     And I should see "You logged into a secure area!" message

  @negative_login_user
  Scenario: Negative login with incorrect user name

    When I click on "Form Authentication" link
    Then I should see "Login" page

    When I enter incorrect user name
     And I enter correct password
     And I click on "Login" button
    Then I should see "Login" page
     And I should see "Your username is invalid!" error message

  @negative_login_password
  Scenario: Negative login with incorrect password

    When I click on "Form Authentication" link
    Then I should see "Login" page

    When I enter correct user name
     And I enter incorrect password
     And I click on "Login" button
    Then I should see "Login" page
     And I should see "Your password is invalid!" error message