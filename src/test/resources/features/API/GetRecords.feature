@Hybrid
  Feature: Get Records


    Background:
      Given the user is logged in and on the dashboard with message "Dashboard"
      And a record is created in the UI
      And token is generated with status code 200

      @getRecord
      Scenario: successfully retrieve a person's record
        Given a request is prepared to retrieve a person's record with email query
        When a GET call is made to retrieve a person's record
        Then response code should be 200
        And the response should match the person's record

