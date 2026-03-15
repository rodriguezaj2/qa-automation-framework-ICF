package steps.UI;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.CommonMethods;
import utils.ConfigReader;

public class LoginSteps extends CommonMethods {

    @Given("the user is logged in and on the dashboard with message {string}")
    public void the_user_is_logged_in_with_message(String expectedMessage) {
        click(aboutPage.menuButton);
        click(aboutPage.signInButton);

        String username = ConfigReader.read("email");
        String password = ConfigReader.read("password");

        sendText(username, loginPage.emailField);
        sendText(password, loginPage.passwordField);

        click(loginPage.loginButton);

        String actualLoginMessage = dashboardPage.dashboardMessage.getText();
        Assert.assertEquals(expectedMessage, actualLoginMessage);
    }

    @When("user clicks on menu button")
    public void user_clicks_on_menu_button() {
        click(aboutPage.menuButton);
    }

    @When("user clicks sign in")
    public void user_clicks_sign_in() {
        click(aboutPage.signInButton);
    }

    @When("user enters valid username {string} and password {string}")
    public void user_enters_valid_username_and_password(String username, String password) {
        String usernameKey = ConfigReader.read(username);
        String passwordKey = ConfigReader.read(password);
        sendText(usernameKey, loginPage.emailField);
        sendText(passwordKey, loginPage.passwordField);
    }

    @When("user clicks login button")
    public void user_clicks_login_button() {
        click(loginPage.loginButton);
    }

    @Then("user is successfully logged in with dashboard showing {string}")
    public void user_is_successfully_logged_in_with_dashboard_showing(String expectedMessage) {
        String actualLoginMessage = dashboardPage.dashboardMessage.getText();
        Assert.assertEquals(expectedMessage, actualLoginMessage);
    }
}
