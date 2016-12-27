package km.steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import km.pages.AddOwnerPage;
import km.pages.FindOwnersPage;
import km.pages.HomePage;
import km.utils.PropertiesReader;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by KrishnaMohan on 26/12/2016.
 */
public class PetDoctorSteps {

    private WebDriver driver;


//    String PET_DOCTOR_URL = "http://localhost:9966/petdoctor/";
    String PET_DOCTOR_URL = PropertiesReader.findProperty("url");

    @Before
    public void createWebDriver() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
//        driver = new HtmlUnitDriver();
    }

    @After
    public void quitWebDriver(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png"); //stick it in the report
        }
        driver.quit();
    }

    @Given("^I am on petdoctor home page$")
    public void openHomePage() throws Throwable {
//        driver.get(PET_DOCTOR_URL);
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.visitPetDoctor(PET_DOCTOR_URL);
    }

    @Then("^I should see petdoctor header$")
    public void i_should_see_pet_doctor_header() throws Throwable {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        Assert.assertTrue(homePage.isHeaderDisplayed());
    }

    @Then("^I should see links for 'Home', 'Find owners' and 'Veterinarians'$")
    public void i_should_see_links_for_Home_Find_owners_and_Veterinarians() throws Throwable {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        Assert.assertTrue(homePage.isHomeLinkDisplayed());
        Assert.assertTrue(homePage.isFindOwnersLinkDisplayed());
        Assert.assertTrue(homePage.isVeterinariansLinkDisplayed());
    }

    @Then("^I should see Welcome text and home page image$")
    public void i_should_see_Welcome_text_and_home_page_image() throws Throwable {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        Assert.assertTrue(homePage.isWelcomeTextDisplayed());
        Assert.assertTrue(homePage.isHomePageImageDisplayed());
    }

    //FR2 steps start==========================

    @When("^I click on Find owners link$")
    public void clickOnFindOwnersLink() throws Throwable {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.clickOnFindOwnersLink();
    }

    @Then("^I should see Find owners page$")
    public void verifyFindOwnersPageIsLoaded() throws Throwable {
        FindOwnersPage findOwnersPage = PageFactory.initElements(driver, FindOwnersPage.class);
        Assert.assertTrue(findOwnersPage.isLoaded());
    }

    @Given("^I am on find owners page$")
    public void i_am_on_find_owners_page() throws Throwable {
        openHomePage();
        clickOnFindOwnersLink();
        verifyFindOwnersPageIsLoaded();
    }

    @When("^I search for owners with text '(.+)'$")
    public void i_search_for_owners_with_text_ab(String searchText) throws Throwable {
        FindOwnersPage findOwnersPage = PageFactory.initElements(driver, FindOwnersPage.class);
        if(searchText.equals("-EMPTY-")){
            searchText = "";
        }
        findOwnersPage.findOwners(searchText);
    }

    @Then("^I should see error message '(.+)' next to last name$")
    public void i_should_see_error_message_Last_Name_must_be_between_and_chars_next_to_last_name(String errorMessage) throws Throwable {
        FindOwnersPage findOwnersPage = PageFactory.initElements(driver, FindOwnersPage.class);
        String errorMessageDisplayed = findOwnersPage.getErrorMessage();
        Assert.assertEquals(errorMessage, errorMessageDisplayed);
    }


    //FR3 steps start==========================

    @When("^I click on Add Owner link$")
    public void goToAddOwnerPage() throws Throwable {
        FindOwnersPage findOwnersPage = PageFactory.initElements(driver, FindOwnersPage.class);
        findOwnersPage.clickOnAddOwnerLink();
    }

    @Then("^I should be on Add Owner page$")
    public void verifyAddOwnerPageIsLoaded() throws Throwable {
        AddOwnerPage addOwnerPage = PageFactory.initElements(driver, AddOwnerPage.class);
        Assert.assertTrue(addOwnerPage.isLoaded());
    }
}
