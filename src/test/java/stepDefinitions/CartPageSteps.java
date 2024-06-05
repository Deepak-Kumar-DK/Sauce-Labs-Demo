package stepDefinitions;

import cucumberContexts.TestContext;
import io.cucumber.java.en.*;
import pageObjects.CartPage;

public class CartPageSteps {

    TestContext testContext;
    CartPage cartPage;

    public CartPageSteps(TestContext context) {
        testContext = context;
        cartPage = testContext.getPageObjectManager().getCartPage();
    }

    @Then("^User moves to checkout from shopping cart$")
    public void moves_to_checkout_from_mini_cart() {
        cartPage.clickOn_Checkout();
    }

}
