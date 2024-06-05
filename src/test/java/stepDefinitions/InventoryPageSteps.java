package stepDefinitions;

import cucumberContexts.TestContext;
import io.cucumber.java.en.*;
import pageObjects.InventoryPage;

public class InventoryPageSteps {

    TestContext testContext;
    InventoryPage inventoryPage;

    public InventoryPageSteps(TestContext context) {
        testContext = context;
        inventoryPage = testContext.getPageObjectManager().getInventoryPage();
    }

    @Given("^User add the inventory items \"([^\"]*)\" to shopping cart and verify item added$")
    public void user_add_the_item_to_cart(String inventoryItems) {
        inventoryPage.addToCart_inventoryItem(inventoryItems);
    }

    @When("^User click the shopping cart icon and moves to cart page$")
    public void user_enter_the_Credentials() {
        inventoryPage.click_Cart_Icon();
    }
}