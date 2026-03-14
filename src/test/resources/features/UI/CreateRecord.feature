@ui
  Feature: create a person's record

Background:
  Given the user is logged in and on the dashboard with message "Dashboard"

    @ui @household @addMember
    Scenario Outline: Add household member using valid required field dropdown values
      And the user clicks 'add record'
      When the user selects "<relationship>" as the relationship
      And the user enters "<firstName>" as the first name
      And the user enters "<lastName>" as the last name
      And the user enters "<dob>" as the date of birth
      And the user selects "<gender>" as the gender
      And the user selects "<hispanic>" as the Hispanic value
      And the user selects "<race>" as the Race value
      And the user selects "<otherStay>" as the Other stay value
      And the user clicks the Update button
      Then the household member should be added successfully with a message containing the text "<confirmation>"

      Examples:
        | relationship       | firstName | lastName      | dob        | gender | hispanic     | race          | otherStay                     | confirmation                      |
        | COSINE             | Jon       | Jones         | 2/15/2018  | Male   | MEXICAN      | BLACK         | OTHER                         | Successfully saved new record for |
        | PARTNER            | Mickey    | Mouse         | 11/18/1928 | Male   | NO           | WHITE         | JOB_OR_BUSINESS               | Successfully saved new record for |
        | SPOUSE             | Donald    | Duck          | 06/09/1934 | Male   | CUBAN        | WHITE         | COLLEGE                       | Successfully saved new record for |
        | BIOLOGICAL_CHILD   | Ariel     | Mermaid       | 11/17/1989 | Female | MEXICAN      | OTHER_PACIFIC | WITH_PARENT_OR_OTHER_RELATIVE | Successfully saved new record for |
        | ROOMMATE_HOUSEMATE | Sora      | Kingdom       | 03/28/2002 | Male   | NO           | JAPANESE      | SEASONAL_OR_SECOND_RESIDENT   | Successfully saved new record for |
        | STEP_CHILD         | Simba     | Lion          | 06/24/1994 | Male   | NO           | BLACK         | WITH_PARENT_OR_OTHER_RELATIVE | Successfully saved new record for |
        | GRANDCHILD         | Elsa      | Arendelle     | 11/27/2013 | Female | PUERTO_RICAN | WHITE         | NO                            | Successfully saved new record for |
        | PARENT             | Goofy     | Goof          | 05/25/1932 | Male   | NO           | WHITE         | JOB_OR_BUSINESS               | Successfully saved new record for |
        | OTHER_NON_RELATIVE | Kairi     | Destiny       | 03/28/2002 | Female | NO_ANSWER    | JAPANESE      | COLLEGE                       | Successfully saved new record for |
        | GRANDPARENT        | YenSid    | Sorcerer      | 11/13/1940 | Male   | NO           | WHITE         | NURSING_HOME                  | Successfully saved new record for |

