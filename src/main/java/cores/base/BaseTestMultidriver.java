package cores.base;

import cores.driver.AppDriver;
import cores.driver.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTestMultidriver {

    @Parameters({"deviceName"})
    @BeforeTest
    public void setup(String deviceName) {
        AppDriver.setDriver(WebDriverManager.getDriverFromParam(deviceName));
    }

    @AfterTest
    public void teardown(){
        AppDriver.getDriver().quit();
    }
}
