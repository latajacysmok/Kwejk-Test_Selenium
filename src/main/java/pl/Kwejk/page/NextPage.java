package pl.Kwejk.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.ArrayList;
import java.util.List;

public class NextPage extends PageObject {

    @FindBy(tagName = "h1")
    private WebElement headerPage;

    @FindBy(tagName = "h2")
    private WebElement pictureHeader;

    private List<String> oldTitleOfPictureList = new ArrayList<String>();
    private List<String> newTitleOfPictureList = new ArrayList<String>();
    int i;

    public NextPage(WebDriver webDriver, String firstPageCounter) {
        super(webDriver);
        i = Integer.parseInt(firstPageCounter);
        i--;
        String currentPageString = Integer.toString(i);
        ExpectedCondition<Boolean> waiterForHeader = driver -> headerPage.getText().contains(currentPageString);
        webDriverWait.until(waiterForHeader);
        firstPageCounter = currentPageString;
//        webDriver.close();
    }

    public void getTextFromPictureHeader() {
        List<WebElement> allLinks = webDriver.findElements(By.tagName("h2"));
//        System.out.println(allLinks.size());
        List<String> oldTitleOfPictureList = new ArrayList<String>(newTitleOfPictureList);//        oldTitleOfPictureList = newTitleOfPictureList;
//        System.out.println("old: " + oldTitleOfPictureList);
        newTitleOfPictureList.clear();
        for (WebElement webElement : allLinks) {
            String name = webElement.getText();
            newTitleOfPictureList.add(name);
//            System.out.println(name);
        }
//        System.out.println(newTitleOfPictureList.equals(oldTitleOfPictureList));
        if(newTitleOfPictureList.equals(oldTitleOfPictureList))
        {
            System.out.println("##########Webpage repetition " + i + " and " + (i-1) + "!!!##########");
            return;
        }

    }
}
