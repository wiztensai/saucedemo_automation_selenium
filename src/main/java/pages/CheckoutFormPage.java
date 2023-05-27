package pages;

import cores.driver.AppDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutFormPage {
    private WebDriver driver;

    public CheckoutFormPage() {
        this.driver = AppDriver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "first-name")
    private WebElement firstNameField;

    @FindBy(id = "last-name")
    private WebElement lastNameField;

    @FindBy(id = "postal-code")
    private WebElement postalCodeField;

    @FindBy(id = "continue")
    private WebElement btnContinue;


    public void inputFirstName(String text) {
        firstNameField.sendKeys(text);
    }

    public void inputLastName(String text) {
        lastNameField.sendKeys(text);
    }

    public void inputPostalCode(String text) {
        postalCodeField.sendKeys(text);
    }

    public void clickBtnContinue() {
        btnContinue.click();
    }
}
