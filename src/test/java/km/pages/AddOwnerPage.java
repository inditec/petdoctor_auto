package km.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddOwnerPage {
    private WebDriver driver;

    @FindBy(how = How.ID, using = "firstName")
    private WebElement firstNameTextField;

    @FindBy(how = How.ID, using = "lastName")
    private WebElement lastNameTextField;

    @FindBy(how = How.ID, using = "address")
    private WebElement addressTextField;

    @FindBy(how = How.ID, using = "city")
    private WebElement cityTextField;

    @FindBy(how = How.ID, using = "telephone")
    private WebElement telephoneTextField;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    private WebElement addOwnerButton;

    @FindBy(how = How.XPATH, using = "//span[@id='error_messages']")
    private WebElement errorMessage;

    public AddOwnerPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isLoaded() {
        return firstNameTextField.isDisplayed()
                && lastNameTextField.isDisplayed()
                && addressTextField.isDisplayed()
                && cityTextField.isDisplayed()
                && telephoneTextField.isDisplayed()
                && addOwnerButton.isDisplayed()
                ;
    }

    public void addOwner(PetOwner owner) {
        firstNameTextField.sendKeys(owner.getFirstName());
        lastNameTextField.sendKeys(owner.getLastName());
        addressTextField.sendKeys(owner.getAddress());
        cityTextField.sendKeys(owner.getCity());
        telephoneTextField.sendKeys(owner.getTelephone());
        addOwnerButton.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }


}
