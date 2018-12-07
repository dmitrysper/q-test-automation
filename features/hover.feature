@web
Feature: Users avatars and information
  As a user of Heroku test app
  I want to see user info displayed when I hover over their avatar pictures
  So that I can get the full information about them

  Background:
    Given I am on the "Start" page

  @hover
  Scenario: Hovering over avatars

    When I click on "Hovers" link
    Then I should see "Hovers" page

    When I hover over first avatar picture
    Then I should see "user1" text

    When I hover over second avatar picture
    Then I should see "user2" text

    When I hover over third avatar picture
    Then I should see "user3" text