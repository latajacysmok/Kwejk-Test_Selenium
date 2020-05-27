package pl.Kwejk;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pl.Kwejk.config.WebDriverType;
import pl.Kwejk.page.MainPage;
import pl.Kwejk.page.NextPage;

public class WebDriverTest {
    @Test
    public void shouldOpenChromeBrawser() {

        WebDriver webDriver = WebDriverType.CHROME.create();
        webDriver.get("https://kwejk.pl/");
        MainPage mainPage = new MainPage(webDriver);
        mainPage.scrollingToTheEndOfThePage();
        NextPage nextPage = mainPage.clickNextButton();
        for (int i = 0; i < 3; i++) {
//            System.out.println("i: "+i);
            mainPage.scrollingToTheEndOfThePage();
            mainPage.clickNextButton();
            nextPage.getTextFromPictureHeader();

        }

        webDriver.quit();
        }

    }

