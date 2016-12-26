package km.steps;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import km.pages.HomePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by KrishnaMohan on 26/12/2016.
 */
public class PetDoctorSteps {

    private WebDriver driver;


    String PET_DOCTOR_URL = "http://localhost:9966/petdoctor/";

    @Before
    public void createWebDriver(){
//        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//        driver = new ChromeDriver();
        driver = new HtmlUnitDriver();
    }

    @After
    public void quitWebDriver(){
        driver.quit();
    }


    @Given("^I am on petdoctor home page$")
    public void i_am_on_pet_doctor_home_page() throws Throwable {
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


}
