package cucumberContexts;

import managers.PageObjectManager;
import managers.WebdriverManager;

public class TestContext {
    private WebdriverManager webdriverManager;
    private PageObjectManager pageObjectManager;

    public TestContext(){
        webdriverManager = new WebdriverManager();
        pageObjectManager = new PageObjectManager(webdriverManager.getDriver());
    }

    public WebdriverManager getWebDriverManager() {
        return webdriverManager;
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }

}