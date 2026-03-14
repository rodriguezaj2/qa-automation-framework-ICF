@Hybrid
Feature: Verify records are being stored in the database

  Background:
    Given the user is logged in and on the dashboard with message "Dashboard"

    @DBValidation
    Scenario:
      When a record is created in the UI
      Then the added person's record is stored in the database