package pages;

import cores.driver.AppDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    private WebDriver driver;

    public ProductPage() {
        this.driver = AppDriver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='title']")
    private WebElement pageTitle;

    @FindBy(xpath = "//div[text()='Sauce Labs Backpack']")
    private WebElement sauceLabsTitle;

    @FindBy(xpath = "//div[text()='Sauce Labs Backpack']/../../..//div[@class='inventory_item_price']")
    private WebElement priceElem;


    public String getPageTitle() {
        return pageTitle.getText();
    }

    public String getPriceText() {
        return priceElem.getText();
    }

    public void clickSauceLabsProduct() {
        sauceLabsTitle.click();
    }
}
