package stepDefinitions;

import cucumberContexts.TestContext;
import io.cucumber.java.en.*;
import managers.FileReaderManager;
import pageObjects.CheckoutPage;
import testDataTypes.Customer;

public class CheckoutPageSteps {
    TestContext testContext;
    CheckoutPage checkoutPage;

    public CheckoutPageSteps(TestContext context) {
        testContext = context;
        checkoutPage = testContext.getPageObjectManager().getCheckoutPage();
    }

    @When("^Enter \"(.*)\" personal details on Checkout: Your Information page$")
    public void enter_personal_details_on_checkout_page(String customerName) {
        Customer customer = FileReaderManager.getInstance().getJsonReader().getCustomerByName(customerName);
        checkoutPage.fill_PersonalDetails(customer);
    }

    @When("^User click the continue button and moves to Checkout: Overview page$")
    public void click_continue_button() {
        checkoutPage.click_continue_button();
    }

    @When("^Verify items \"([^\"]*)\" in Checkout: Overview page$")
    public void verify_items_in_checkout_overview_page(String items) {
        checkoutPage.check_itemsInCheckoutOverviewPage(items);
    }

    @When("^User click the finish button and moves to Checkout: Complete! page$")
    public void click_finish_button() {
        checkoutPage.click_finish_button();
    }

    @When("^User click the back Home button and moves to inventory page$")
    public void click_backHome_button() {
        checkoutPage.click_backHome_button();
    }

}
