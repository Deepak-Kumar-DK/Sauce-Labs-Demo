package pageObjects;

import io.cucumber.core.logging.Logger;
import io.cucumber.core.logging.LoggerFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import testDataTypes.Customer;

import java.util.List;

public class CheckoutPage {
    private static final Logger logger = LoggerFactory.getLogger(CartPage.class);
    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "first-name")
    private WebElement txtbx_FirstName;

    @FindBy(how = How.ID, using = "last-name")
    private WebElement txtbx_LastName;

    @FindBy(how = How.ID, using = "postal-code")
    private WebElement txtbx_ZipPostalCode;

    @FindBy(how = How.ID, using = "continue")
    private WebElement btn_continue;

    @FindBy(how = How.XPATH, using = "//span[@class='title']")
    private WebElement pagetitle;

    @FindBy(how = How.XPATH, using = "//div[@class='cart_list']/div[@class='cart_item']")
    private List<WebElement> cartList;

    @FindBy(how = How.ID, using = "finish")
    private WebElement btn_finish;

    @FindBy(how = How.XPATH, using = "//h2[contains(text(),'Thank you for your order!')]")
    private WebElement lbl_ThankYou;

    @FindBy(how = How.ID, using = "back-to-products")
    private WebElement btn_backHome;


    public void fill_PersonalDetails(Customer customer) {
        try {
            Assert.assertEquals("Checkout: Your Information", pagetitle.getText());
            txtbx_FirstName.sendKeys(customer.firstName);
            logger.info(()->"First Name entered as " + customer.firstName);
            Assert.assertEquals(txtbx_FirstName.getAttribute("value"), customer.firstName);
            txtbx_LastName.sendKeys(customer.lastName);
            logger.info(()->"Last Name entered as " + customer.lastName);
            Assert.assertEquals(txtbx_LastName.getAttribute("value"), customer.lastName);
            txtbx_ZipPostalCode.sendKeys(customer.zipPostalCode);
            logger.info(()->"Zip/Postal Code entered as " + customer.zipPostalCode);
            Assert.assertEquals(txtbx_ZipPostalCode.getAttribute("value"), customer.zipPostalCode);
        } catch (AssertionError ae) {
            logger.error(ae::getMessage);
            throw ae;
        }
    }

    public void click_continue_button() {
        try {
            btn_continue.click();
            logger.info(()->"Continue button clicked");
            Assert.assertEquals("Checkout: Overview", pagetitle.getText());
        } catch (AssertionError ae) {
            logger.error(ae::getMessage);
            throw ae;
        }
    }

    public void check_itemsInCheckoutOverviewPage(String items) {
        try {
            String[] totalItem = items.split(";");
            logger.info(()->"Expected Total item: " + totalItem.length + " Actual Total item: " + cartList.size());
            Assert.assertEquals(totalItem.length, cartList.size());
            String actualItemXpath = "//div[contains(text(),'";
            for (String item : totalItem) {
                Assert.assertEquals(item, driver.findElement(By.xpath(actualItemXpath + item + "')]")).getText());
            }
        } catch (AssertionError ae) {
            logger.error(ae::getMessage);
            throw ae;
        }
    }

    public void click_finish_button() {
        try {
            btn_finish.click();
            logger.info(()->"Finish button clicked");
            Assert.assertEquals("Checkout: Complete!", pagetitle.getText());
            Assert.assertTrue(lbl_ThankYou.isDisplayed());
        } catch (AssertionError ae) {
            logger.error(ae::getMessage);
            throw ae;
        }
    }

    public void click_backHome_button() {
        try {
            btn_backHome.click();
            logger.info(()->"Back Home button clicked");
            Assert.assertEquals("Products", pagetitle.getText());
        } catch (AssertionError ae) {
            logger.error(ae::getMessage);
            throw ae;
        }
    }

}
