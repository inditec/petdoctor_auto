package km.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FindOwnersPage {
    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//input[@id='lastName']")
    private WebElement lastNameTextField;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    private WebElement findOwnersButton;

    @FindBy(how = How.LINK_TEXT, using = "Add Owner")
    private WebElement addOwnerLink;

    @FindBy(how = How.XPATH, using = "//span[@id='error_messages']")
    private WebElement errorMessage;

    public FindOwnersPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isLoaded() {
        return lastNameTextField.isDisplayed() && findOwnersButton.isDisplayed();
    }

    public void findOwners(String searchText) {
        lastNameTextField.sendKeys(searchText);
        findOwnersButton.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public void clickOnAddOwnerLink() {
        addOwnerLink.click();
    }


}
