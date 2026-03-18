package steps.DBValidation;

import io.cucumber.java.en.Then;
import io.cucumber.messages.ndjson.internal.com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import steps.UI.CreateRecordSteps;
import utils.DBUtils;
import utils.ScenarioContext;

import java.util.Map;

public class DBValidationSteps {

    @Then("the added person's record is stored in the database")
    public void the_added_person_s_record_is_stored_in_the_database() throws Exception {

        Map<String, String> record = DBUtils.getLatestRecord();

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(record);

        //System.out.println(jsonResponse);
    }

    @Then("the record in the database matches the created data")
    public void the_record_in_the_database_matches_the_created_data() {

        String uiFirstName = ScenarioContext.personRecord.getFirstName();
        String uiLastName = ScenarioContext.personRecord.getLastName();

        Map<String, String> record = DBUtils.getLatestRecord();
        String dbFirstName = record.get("firstName");
        String dbLastName = record.get("lastName");

        System.out.println("This is first name " + uiFirstName);
        System.out.println("This is last name " + uiLastName);

        Assert.assertEquals(uiFirstName,dbFirstName);
        Assert.assertEquals(uiLastName,dbLastName);

    }

}
