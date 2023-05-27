package cores.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverManager {
    static private String driverPath = "E:/My_Software_Project/Selenium Projects/selenium_driver/";

    static public WebDriver chromeDriver(){
        System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
        return new ChromeDriver();
    }

    static public WebDriver firefoxDriver(){
        System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver.exe");
        var option = new FirefoxOptions();
        option.setBinary("C:/Program Files/Mozilla Firefox/firefox.exe");
        return new FirefoxDriver(option);
    }

    static public WebDriver edgeDriver(){
        System.setProperty("webdriver.edge.driver", driverPath + "msedgedriver.exe");
        return new EdgeDriver();
    }

    static public WebDriver getDriverFromParam(String deviceName) {
        if (deviceName.equalsIgnoreCase("chrome")) {
            return WebDriverManager.chromeDriver();
        } else if (deviceName.equalsIgnoreCase("firefox")) {
            return WebDriverManager.firefoxDriver();
        } else if (deviceName.equalsIgnoreCase("edge")) {
            return WebDriverManager.edgeDriver();
        } else {
            return WebDriverManager.chromeDriver();
        }
    }
}
