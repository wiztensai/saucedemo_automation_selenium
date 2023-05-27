package pages;

import cores.driver.AppDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {
    private WebDriver driver;

    public LoginPage() {
        this.driver = AppDriver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(className = "login_credentials")
    private WebElement acceptedUsernames;

    @FindBy(className = "login_password")
    private WebElement acceptedPassword;

    @FindBy(className = "btn_action")
    private WebElement btnLogin;

    public String getUsername() {
        String[] names = acceptedUsernames.getText().split("\n");
        String filteredName = "";
        for (String name : names) {
            if (name.contains("standard")) {
                filteredName = name;
                break;
            }
        }
        return filteredName;
    }

    public String getPassword() {
        String[] pwds = acceptedPassword.getText().split("\n");
        String filteredPwd = "";
        for (String pwd : pwds) {
            if (pwd.contains("secret")) {
                filteredPwd = pwd;
                break;
            }
        }
        return filteredPwd;
    }

    public void inputUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void inputPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickBtnLogin() {
        btnLogin.click();
    }
}
