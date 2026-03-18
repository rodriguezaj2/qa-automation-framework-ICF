@ui
Feature: Delete household member record

  Background:
    Given the user is logged in and on the dashboard with message "Dashboard"
    And a record is created in the UI
    And token is generated with status code 200
    And a request is prepared to retrieve a person's record with email query

    @deleteRecord
  Scenario: User deletes a household member record
      When a GET call is made to retrieve a person's record
      And the user clicks the ok button
      And the user clicks deletes on the created record
      Then the delete confirmation modal is displayed
      And the user confirms deletion
      And user clicks ok
      Then the record should be deleted