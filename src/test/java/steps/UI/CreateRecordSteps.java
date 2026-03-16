package steps.UI;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import utils.CommonMethods;
import utils.HouseholdMember;

public class CreateRecordSteps extends CommonMethods {

    public String relationship;
    public static String firstName;
    public static String lastName;

    @Given("the user clicks {string}")
    public void the_user_clicks(String string) {
       click(dashboardPage.addRecordButton);
    }

    @When("the user selects {string} as the relationship")
    public void the_user_selects_as_the_relationship(String relationship) {
        this.relationship=relationship;
        Select select = new Select(addHouseholdMemberModal.relationshipDropdown);
        select.selectByVisibleText(relationship);
    }

    @When("the user enters {string} as the first name")
    public void the_user_enters_as_the_first_name(String firstName) {
        sendText(firstName, addHouseholdMemberModal.firstNameField);
    }

    @When("the user enters {string} as the last name")
    public void the_user_enters_as_the_last_name(String lastName) {
        sendText(lastName, addHouseholdMemberModal.lastNameField);
    }

    @When("the user enters {string} as the date of birth")
    public void the_user_enters_as_the_date_of_birth(String DOB) {
        addHouseholdMemberModal.selectDOB(DOB);
    }

    @When("the user selects {string} as the gender")
    public void the_user_selects_as_the_gender(String gender) {
        addHouseholdMemberModal.selectGender(gender);
    }

    @When("the user selects {string} as the Hispanic value")
    public void the_user_selects_as_the_hispanic_value(String hispanic) {
      addHouseholdMemberModal.selectHispanic(hispanic);
    }

    @When("the user selects {string} as the Race value")
    public void the_user_selects_as_the_race_value(String race) {
        addHouseholdMemberModal.selectRace(race);
    }

    @When("the user selects {string} as the Other stay value")
    public void the_user_selects_as_the_other_stay_value(String otherStay) {
        addHouseholdMemberModal.selectOtherStay(otherStay);
    }

    @When("the user clicks the Update button")
    public void the_user_clicks_the_update_button() {
        click(addHouseholdMemberModal.updateButton);
    }

    @Then("the household member should be added successfully with a message containing the text {string}")
    public void the_household_member_should_be_added_successfully_with_a_message_containing_the_text(String confirmation) {
       Assert.assertEquals(confirmation + " " + "'" + relationship + "'",addHouseholdMemberModal.getConfirmationText(confirmation));
    }

    @Given("a record is created in the UI")
    public void a_record_is_created_in_the_ui() {

        firstName = "Best";
        lastName = "Name";
        addHouseholdMemberModal.createMember(


                "SPOUSE",
                firstName,
                lastName,
                "2/15/2018",
                "Male",
                "MEXICAN",
                "BLACK",
                "OTHER"
        );
    }

}
