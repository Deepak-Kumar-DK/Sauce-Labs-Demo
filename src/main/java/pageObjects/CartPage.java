package pageObjects;

import dataProviders.ConfigFileReader;
import io.cucumber.core.logging.Logger;
import io.cucumber.core.logging.LoggerFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    private static final Logger logger = LoggerFactory.getLogger(CartPage.class);
    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "checkout")
    private WebElement btn_Checkout;

    public void clickOn_Checkout() {
        try {
            btn_Checkout.click();
            logger.info(() -> "Checkout button clicked");
            String actualUrl = driver.getCurrentUrl();
            String expectedUrl = "https://www.saucedemo.com/checkout-step-one.html";
            Assert.assertEquals(expectedUrl, actualUrl);
        } catch (AssertionError ae) {
            logger.error(ae::getMessage);
            throw ae;
        }
    }
}
