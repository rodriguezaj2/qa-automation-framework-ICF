package steps.API;

import io.cucumber.java.en.Given;
import utils.TokenGeneration;

public class TokenGenerationSteps {


    @Given("token is generated with status code {int}")
    public void token_is_generated_with_status_code(int expectedStatusCode) {

        TokenGeneration tokenGeneration = new TokenGeneration();
        int actualStatusCode = tokenGeneration.token(expectedStatusCode);
        System.out.println("The status code is " + expectedStatusCode);
    }

}
