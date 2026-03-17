@Hybrid
Feature: Verify records are being stored in the database

  Background:
    Given the user is logged in and on the dashboard with message "Dashboard"
    And a record is created in the UI
    And token is generated with status code 200

    @DBValidation
    Scenario:
      Given a request is prepared to retrieve a person's record with email query
      When a GET call is made to retrieve a person's record
      Then the added person's record is stored in the database
      And the record in the database matches the created data