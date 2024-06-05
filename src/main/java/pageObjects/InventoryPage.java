package pageObjects;

import io.cucumber.core.logging.Logger;
import io.cucumber.core.logging.LoggerFactory;
import managers.FileReaderManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {
    private static final Logger logger = LoggerFactory.getLogger(CartPage.class);
    WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//span[@class='title']")
    private WebElement pagetitle;

    @FindBy(how = How.XPATH, using = "//span[@class='shopping_cart_badge']")
    private WebElement shoppingCartBadge;

    @FindBy(how = How.XPATH, using = "//a[@class='shopping_cart_link']")
    private WebElement shoppingCartLink;

    private static int noOfItems;

    public void addToCart_inventoryItem(String inventoryItems) {
        try {
            Assert.assertEquals("Products", pagetitle.getText());
            String[] items = inventoryItems.split(";");
            logger.info(() -> "Total items needs to add in cart: " + items.length);
            for (String inventoryItem : items) {
                String inventoryItemXpath = "//div[contains(text(),'";
                String addToCartXpath = "')]/../../..//button[contains(text(),'Add to cart')]";
                driver.findElement(By.xpath(inventoryItemXpath + inventoryItem + addToCartXpath)).click();
                if (shoppingCartBadge.isDisplayed()) {
                    noOfItems++;
                    Assert.assertEquals(noOfItems, Integer.parseInt(shoppingCartBadge.getText()));
                } else
                    Assert.assertFalse("Fail to add Item into Shopping cart", shoppingCartBadge.isDisplayed());
                logger.info(() -> "Items added in cart: " + inventoryItem);
            }
        } catch (AssertionError ae) {
            logger.error(ae::getMessage);
            throw ae;
        }
    }

    public void click_Cart_Icon() {
        try {
            shoppingCartLink.click();
            logger.info(() -> "Cart Icon clicked");
            String actualUrl = driver.getCurrentUrl();
            String expectedUrl = "https://www.saucedemo.com/cart.html";
            Assert.assertEquals(expectedUrl, actualUrl);
        } catch (AssertionError ae) {
            logger.error(ae::getMessage);
            throw ae;
        }
    }
}
