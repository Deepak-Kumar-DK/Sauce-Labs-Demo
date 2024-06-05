package stepDefinitions;

import com.google.common.io.Files;
import cucumberContexts.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class Hooks {
    TestContext testContext;

    public Hooks(TestContext context) {
        testContext = context;
    }

    @Before
    public void BeforeSteps(Scenario scenario) {
    }

    @After
    public void AfterSteps() {
        testContext.getWebDriverManager().closeDriver();
    }
}
