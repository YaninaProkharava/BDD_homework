package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObject.HomePage;
import org.example.pageObject.modules.ZipCodeInputModule;
import org.testng.Assert;

public class ZipCodeUpdatePageSteps {
    HomePage homePage = new HomePage(BaseSteps.webDriver);
    @Given("User is on Main page")
    public void userIsOnPage(){
        homePage.open();
    }

    @When("User enters zipcode {string}")
    public void userEntersZipCode(String zipCode){
        ZipCodeInputModule zipCodeInputModule = homePage.clickDeliverTo();
        zipCodeInputModule.setZipCodeAndApply(zipCode);
        homePage.waitForReload();
    }

    @Then("Zipcode {string} is present on {string}")
    public void userIsOnReloadedPage(String zipCode, String url){
        Assert.assertEquals(url, BaseSteps.webDriver.getCurrentUrl());
        String deliverToText = homePage.getDeliverToText();
        Assert.assertTrue(deliverToText.contains(zipCode),
                "Delivery To Textbox doesn't contain the required zipcode");
    }
}
