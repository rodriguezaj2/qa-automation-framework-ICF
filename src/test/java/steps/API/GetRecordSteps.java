package steps.API;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.ndjson.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import steps.UI.CreateRecordSteps;
import utils.APIConstants;
import utils.ConfigReader;
import utils.DBUtils;
import utils.TokenGeneration;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRecordSteps {

    RequestSpecification req;
    Response resp;
    public static String firstName;
    String email = ConfigReader.read("email");
    Map<String, Object> latestMatch;
    public static int apiID;
    public static int dbID;

    @Given("a request is prepared to retrieve a person's record with email query")
    public void a_request_is_prepared_to_retrieve_a_person_s_record_with_email_query() {
        req=given().cookies(TokenGeneration.authCookies).header(APIConstants.HEADER_CONTENT_TYPE_KEY,APIConstants.HEADER_CONTENT_TYPE_VALUE)
                .accept(APIConstants.HEADER_CONTENT_TYPE_VALUE).queryParam("email" , email);

    }
    @When("a GET call is made to retrieve a person's record")
    public void a_get_call_is_made_to_retrieve_a_person_s_record() throws Exception {
        resp = req.when().get(APIConstants.GET_USER_BY_QUERY);


        List<Map<String, Object>> createdRecords = resp.jsonPath()
                .getList("records.findAll { it.firstName == '" + CreateRecordSteps.firstName +
                        "' && it.lastName == '" + CreateRecordSteps.lastName + "' }");

        latestMatch = createdRecords.get(createdRecords.size() - 1);

        ObjectMapper mapper = new ObjectMapper();

        String prettyJson = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(latestMatch);

        System.out.println(prettyJson);


    }
    @Then("response code should be {int}")
    public void response_code_should_be(Integer statusCode) {
        int actualStatusCode = resp.getStatusCode();
        resp.then().statusCode(statusCode);

    }
    @Then("the response should match the person's record")
    public void the_response_should_match_the_person_s_record() {
        apiID =(Integer) latestMatch.get("id");

        Map<String, String> record = DBUtils.getLatestRecord();
        dbID = Integer.parseInt(record.get("id"));

        Assert.assertEquals(apiID,dbID);
    }

}
