package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObject.CatalogItemPage;
import org.example.pageObject.CatalogPage;
import org.example.pageObject.modules.ZipCodeInputModule;
import org.testng.Assert;


public class ShippingToSectionPageSteps {

    private CatalogItemPage catalogItemPage;

    @When("User chooses {string} in Delivery To section")
    public void setDeliverToCountry(String countryName){
        ZipCodeInputModule zipCodeInputModule = BaseSteps.homePage.clickDeliverTo();
        zipCodeInputModule.chooseCountryAndApply(countryName);
        BaseSteps.homePage.waitForReload();
    }

    @And("User goes to Headsets Catalog and chooses Catalog item")
    public void chooseCatalogItem(){
        CatalogPage catalogPage = BaseSteps.homePage.clickHeadsetsCatalog();
        catalogItemPage = catalogPage.clickCatalogItem();
    }

    @Then("{string} is present in Shipping To section")
    public void verifyCountryInShippingToSection(String countryName){
        Assert.assertTrue(catalogItemPage.getDeliveryCountryName().contains(countryName),
                "Catalog item delivery country is not " + countryName);
    }


}
