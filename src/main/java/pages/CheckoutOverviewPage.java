package pages;

import cores.driver.AppDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewPage {
    private WebDriver driver;

    public CheckoutOverviewPage() {
        this.driver = AppDriver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text()='Finish']")
    private WebElement btnFinish;

    public void clickBtnFinish() {
        btnFinish.click();
    }
}
