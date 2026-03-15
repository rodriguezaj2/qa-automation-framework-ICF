package steps.DBValidation;

import io.cucumber.java.en.Then;
import io.cucumber.messages.ndjson.internal.com.fasterxml.jackson.databind.ObjectMapper;
import utils.DBUtils;

import java.util.List;
import java.util.Map;

public class DBValidationSteps {

    @Then("the added person's record is stored in the database")
    public void the_added_person_s_record_is_stored_in_the_database() throws Exception {
        String query = "SELECT * FROM public.\"Record\" ORDER BY id DESC LIMIT 1";
        List<Map<String,String>> recordsData= DBUtils.fetch(query);

        Map<String, String> record = recordsData.get(0);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(record);

        System.out.println(jsonResponse);
    }
}
