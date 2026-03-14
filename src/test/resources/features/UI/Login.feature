@ui
Feature: login functionality

@login
Scenario Outline: valid login
  When user clicks on menu button
  And user clicks sign in
  And user enters valid username "<usernameKey>" and password "<passwordKey>"
  And user clicks login button
  Then user is successfully logged in with dashboard showing "<expectedMessage>"

  Examples:
    | usernameKey | passwordKey | expectedMessage |
    | email       | password    | Dashboard       |