package pages;

import cores.driver.AppDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    private WebDriver driver;

    public CheckoutPage() {
        this.driver = AppDriver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text()='Checkout']")
    private WebElement btnCheckout;

    @FindBy(className = "inventory_item_price")
    private WebElement priceElem;

    public void clickBtnCheckout() {
        btnCheckout.click();
    }

    public String getPriceText() {
        return priceElem.getText();
    }
}
