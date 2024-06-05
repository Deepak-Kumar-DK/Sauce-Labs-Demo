package pageObjects;

import io.cucumber.core.logging.Logger;
import io.cucumber.core.logging.LoggerFactory;
import managers.FileReaderManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private static final Logger logger = LoggerFactory.getLogger(CartPage.class);
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "user-name")
    private WebElement username;

    @FindBy(how = How.ID, using = "password")
    private WebElement password;

    @FindBy(how = How.ID, using = "login-button")
    private WebElement btn_login;
    public void navigateTo_login_page() {
        try {
            driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
            Assert.assertEquals("Swag Labs", driver.getTitle());
        } catch (AssertionError ae) {
            logger.error(ae::getMessage);
            throw ae;
        }
    }

    public void enter_Credentials(String username, String password) {
        try {
            this.username.sendKeys(username);
            Assert.assertEquals(this.username.getAttribute("value"), username);
            this.password.sendKeys(password);
            Assert.assertEquals(this.password.getAttribute("value"), password);
        } catch (AssertionError ae) {
            logger.error(ae::getMessage);
            throw ae;
        }
    }

    public void click_Login_Button() {
        try {
            btn_login.click();
            logger.info(() -> "Login button clicked");
            String actualUrl = driver.getCurrentUrl();
            String expectedUrl = "https://www.saucedemo.com/inventory.html";
            Assert.assertEquals(expectedUrl, actualUrl);
        } catch (AssertionError ae) {
            logger.error(ae::getMessage);
            throw ae;
        }
    }

}
