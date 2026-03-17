package steps.UI;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import steps.API.GetRecordSteps;
import utils.CommonMethods;
import utils.DBUtils;
import steps.API.GetRecordSteps;
import utils.ScenarioContext;

import java.util.Map;

public class DeleteRecordSteps extends CommonMethods {

    Map<String, Object> latestMatch;

    @When("the user clicks the ok button")
    public void the_user_clicks_the_ok_button() {
        click(addHouseholdMemberModal.okButton);
    }

    @When("the user clicks deletes on the created record")
    public void the_user_clicks_deletes_on_the_created_record() {
        dashboardPage.clickLastDeleteButton();
    }
    @Then("the delete confirmation modal is displayed")
    public void the_delete_confirmation_modal_is_displayed() {
        waitForElementToBeClickable(deleteModalPage.confirmationModal);
        Assert.assertTrue(deleteModalPage.confirmationModal.isDisplayed());
    }
    @Then("the user confirms deletion")
    public void the_user_confirms_deletion() {
        waitForElementToBeClickable(deleteModalPage.deleteConfirmationButton);
        click(deleteModalPage.deleteConfirmationButton);
    }

    @Then("user clicks ok")
    public void user_clicks_ok() {
        waitForElementToBeClickable(deleteModalPage.okButton);
        click(deleteModalPage.okButton);
    }

    @Then("the record should be deleted")
    public void the_record_should_be_deleted() {

        int apiID = ScenarioContext.apiID;

        Map<String,String> record = DBUtils.getRecordById(apiID);

        System.out.println("This is API ID " + apiID);
        System.out.println("This is database data " + record);

        Assert.assertNull("Record still exists in database", record);


    }
}
