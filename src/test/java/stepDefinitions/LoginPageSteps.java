package stepDefinitions;

import cucumberContexts.TestContext;
import io.cucumber.java.en.*;
import pageObjects.LoginPage;

public class LoginPageSteps {

    TestContext testContext;
    LoginPage loginPage;

    public LoginPageSteps(TestContext context) {
        testContext = context;
        loginPage = testContext.getPageObjectManager().getLoginPage();
    }

    @Given("^User navigate to login page$")
    public void user_is_on_Login_Page() {
        loginPage.navigateTo_login_page();
    }

    @Then("^Enter the Credentials \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_enter_the_Credentials(String Username, String Password) {
        loginPage.enter_Credentials(Username, Password);
    }

    @Then("User click the login button and moves to inventory page")
    public void user_click_the_login_button() {
        loginPage.click_Login_Button();
    }
}