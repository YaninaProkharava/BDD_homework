package StepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.example.factory.WebDriverFactory;
import org.example.pageObject.HomePage;
import org.openqa.selenium.WebDriver;


public class BaseSteps {

    public static HomePage homePage;
    public static WebDriver webDriver;

    @Before
    public void initWebDriver(){
        webDriver = new WebDriverFactory().getWebDriver();
        homePage = new HomePage(webDriver);
    }

    @After
    public void afterScenario(){
        webDriver.close();
        webDriver.quit();
    }
}
