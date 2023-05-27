package cores.driver;

import org.openqa.selenium.WebDriver;

public class AppDriver {
    static ThreadLocal <WebDriver> driver = new ThreadLocal<>();

    static public WebDriver getDriver() {
        return driver.get();
    }

    static public void setDriver(WebDriver driver) {
        AppDriver.driver.set(driver);
    }
}
