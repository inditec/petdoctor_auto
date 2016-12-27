package km.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public class HomePage {
    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//img[contains(@src, 'banner-graphic.png')]")
    private WebElement header;

    @FindBy(how = How.LINK_TEXT, using = "Home")
    private WebElement homeLink;

    @FindBy(how = How.LINK_TEXT, using = "Find owners")
    private WebElement findOwnersLink;

    @FindBy(how = How.LINK_TEXT, using = "Veterinarians")
    private WebElement veterinariansLink;

    @FindBy(how = How.XPATH, using = "//h2[text()='Welcome']")
    private WebElement welcomeText;


    @FindBy(how = How.XPATH, using = "//img[contains(@src, 'pets.png')]")
    private WebElement homePageImage;


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void visitPetDoctor(String url) {
        driver.get(url);
    }

    public boolean isHeaderDisplayed() {
        return header.isDisplayed();
    }

    public boolean isHomeLinkDisplayed() {
        return homeLink.isDisplayed();
    }

    public boolean isFindOwnersLinkDisplayed() {
        return findOwnersLink.isDisplayed();
    }

    public boolean isVeterinariansLinkDisplayed() {
        return veterinariansLink.isDisplayed();
    }

    public boolean isWelcomeTextDisplayed() {
        return welcomeText.isDisplayed();
    }

    public boolean isHomePageImageDisplayed() {
        return homePageImage.isDisplayed();
    }

    public void clickOnFindOwnersLink() {
        findOwnersLink.click();
    }


    //=======================================================
    private Map<String, String> data;

    private int timeout = 15;


    @FindBy(css = "a[href='/petdoctor/']")
    @CacheLookup
    private WebElement home;

    private final String pageLoadedText = "";

    private final String pageUrl = "/petdoctor/";


    public HomePage() {
    }


    public HomePage(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
    }

    public HomePage(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
    }


    /**
     * Click on Find Owners Link.
     *
     * @return the HomePage class instance.
     */


    /**
     * Click on Home Link.
     *
     * @return the HomePage class instance.
     */
    public HomePage clickHomeLink() {
        home.click();
        return this;
    }

    /**
     * Click on Veterinarians Link.
     *
     * @return the HomePage class instance.
     */
    public HomePage clickVeterinariansLink() {
        veterinariansLink.click();
        return this;
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return the HomePage class instance.
     */
    public HomePage verifyPageLoaded() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getPageSource().contains(pageLoadedText);
            }
        });
        return this;
    }

    /**
     * Verify that current page URL matches the expected URL.
     *
     * @return the HomePage class instance.
     */
    public HomePage verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }
}
