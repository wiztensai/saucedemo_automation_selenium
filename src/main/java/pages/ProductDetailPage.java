package pages;

import cores.driver.AppDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPage {
    private WebDriver driver;

    public ProductDetailPage() {
        this.driver = AppDriver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text() = 'Add to cart']")
    private WebElement btnAddToCart;

    @FindBy(id = "shopping_cart_container")
    private WebElement btnShoppingCart;

    public void clickBtnAddToCart() {
        btnAddToCart.click();
    }

    public void clickBtnShoppingCart() {
        btnShoppingCart.click();
    }
}
