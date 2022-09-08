package StepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObject.modules.ZipCodeInputModule;
import org.testng.Assert;

public class ListOfCountriesPageSteps {

    private ZipCodeInputModule zipCodeInputModule;

    @When("User opens List of countries")
    public void openListOfCountries(){
        zipCodeInputModule = BaseSteps.homePage.clickDeliverTo();
    }

    @Then("{string} is present in the List of countries")
    public void verifyPolandIsPresent(String countryName){
        Assert.assertTrue(
                zipCodeInputModule.deliverToListOfCounties().stream().anyMatch(c -> c.equals(countryName)),
                "List of countries doesn't contain " + countryName);
    }
}
