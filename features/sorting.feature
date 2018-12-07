@web
Feature: Sorting
  As a user of Heroku test app
  I want to be able to change sorting order in data tables
  So that data is displayed in the most convenient way

  Background:
    Given I am on the "Start" page

  @sorting
  Scenario: Ascending and descending sorting order

    When I click on "Sortable Data Tables" link
    Then I should see "Data Tables" page
     And I should see that last names are not sorted

    When I change sorting order of the last names
    Then I should see that last names are sorted in ascending order

    When I change sorting order of the last names
    Then I should see that last names are sorted in descending order