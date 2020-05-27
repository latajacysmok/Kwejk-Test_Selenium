package pl.Kwejk.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public enum WebDriverType {

    FIREFOX {
        @Override
        public WebDriver create() {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }
    },
    CHROME {
        @Override
        public WebDriver create() {
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver(capabilities);
        }
    },
    IE {
        @Override
        public WebDriver create() {
            WebDriverManager.iedriver().arch32().setup();
            return new InternetExplorerDriver();
        }
    };

    public abstract WebDriver create();//funckja abstrakcyjna nie posiada ciała funkcji;
}
