package steps;

import io.cucumber.java.en.Then;
import utils.DBUtils;

import java.util.List;
import java.util.Map;

public class DBValidationSteps {

    @Then("the added person's record is stored in the database")
    public void the_added_person_s_record_is_stored_in_the_database() {
        String query = "SELECT * FROM public.\"Record\" ORDER BY id DESC LIMIT 1";
        List<Map<String,String>> employeeData= DBUtils.fetch(query);
        String dbFirstName=employeeData.get(0).get("firstName");
        String dbLastName=employeeData.get(0).get("lastName");

        System.out.println(dbFirstName);
        System.out.println(dbLastName);
    }
}
