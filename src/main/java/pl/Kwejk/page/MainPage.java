package pl.Kwejk.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends PageObject{

    @FindBy(tagName = "h1")
    private WebElement headerPage;

    @FindBy(xpath = "//a[@class='btn btn-next btn-gold']")
    private WebElement nextPageButton;

    @FindBy(xpath = "//li[@class='current']/a[1]")
    private WebElement currentPageCounter;

    @FindBy(className = "summary_summary--39BrN")
    private WebElement popUpWindow;

    @FindBy(xpath = "//button[@class='button_button--lgX0P details_save--1ja7w ']")
    private WebElement acceptButton;

    @FindBy(className = "uPIddk")
    private WebElement laughWindow;

    @FindBy(className = "u0V3zH")
    private WebElement maybeLaterButton;

    String firstPageCounter;

    public MainPage(WebDriver webDriver) {
        super(webDriver);
        webDriverWait.until(ExpectedConditions.visibilityOf(headerPage));
        webDriverWait.until(ExpectedConditions.visibilityOf(popUpWindow));
        if(acceptButton.isDisplayed())
            acceptButton.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(laughWindow));
        if(maybeLaterButton.isDisplayed())
            maybeLaterButton.click();

    }

    public void scrollingToTheEndOfThePage(){
        Actions actions = new Actions(webDriver);
        actions.moveToElement(nextPageButton);
        actions.perform();
    }

    public NextPage clickNextButton(){
        String firstPageCounter = currentPageCounter.getText();
        System.out.println("Current page number: "+currentPageCounter.getText());
//        System.out.println("First: "+firstPageCounter);
        nextPageButton.click();
        return new NextPage(webDriver, firstPageCounter);
    }


}
