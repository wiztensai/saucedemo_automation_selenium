package pages;

import cores.driver.AppDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage {
    private WebDriver driver;

    public CheckoutCompletePage() {
        this.driver = AppDriver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='complete-text']")
    private WebElement orderInformationElem;

    public String getCheckoutInformation() {
        return orderInformationElem.getText();
    }
}
