package steps.API;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.APIConstants;
import utils.ConfigReader;
import utils.TokenGeneration;

import static io.restassured.RestAssured.given;

public class GetRecordSteps {

    RequestSpecification req;
    Response resp;
    public static String firstName;
    String email = ConfigReader.read("email");

    @Given("a request is prepared to retrieve a person's record with email query")
    public void a_request_is_prepared_to_retrieve_a_person_s_record_with_email_query() {
        req=given().cookies(TokenGeneration.authCookies).header(APIConstants.HEADER_CONTENT_TYPE_KEY,APIConstants.HEADER_CONTENT_TYPE_VALUE).accept(APIConstants.HEADER_CONTENT_TYPE_VALUE).queryParam("email" , email);
        System.out.println("This is email " + email);
        System.out.println("Email being passed is: " + email);

    }
    @When("a GET call is made to retrieve a person's record")
    public void a_get_call_is_made_to_retrieve_a_person_s_record() {
        resp = req.when().get(APIConstants.GET_USER_BY_QUERY);
        firstName=resp.jsonPath().getString("records.firstName");
        System.out.println("These are first names " + firstName);
        resp.prettyPrint();

        /*resp = req
                .log().all()
                .when()
                .get(APIConstants.GET_USER_BY_QUERY);*/

        System.out.println("Content-Type: " + resp.getContentType());
        System.out.println("Response body: " + resp.getBody().asString());

        System.out.println("This is the response we are getting "+ resp.getContentType());

    }
    @Then("response code should be {int}")
    public void response_code_should_be(Integer statusCode) {
        int actualStatusCode = resp.getStatusCode();
        resp.then().statusCode(statusCode);
        System.out.println("Query status code is "+ actualStatusCode);
        System.out.println("Print URL " + APIConstants.GET_USER_BY_QUERY);

    }
    @Then("the response should match the person's record")
    public void the_response_should_match_the_person_s_record() {

    }

}
