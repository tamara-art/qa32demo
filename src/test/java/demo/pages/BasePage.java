package demo.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void type(WebElement fieldWebElement, String text) {
        waitForElementToBeClickable(fieldWebElement);
        fieldWebElement.click();
        fieldWebElement.sendKeys(text);
    }

    protected void clearAndType(WebElement fieldWebElement, String text) {
        waitForElementToBeClickable(fieldWebElement);
        fieldWebElement.click();
        fieldWebElement.clear();
        fieldWebElement.sendKeys(text);
    }

    protected void scrollToElementAndClick(WebElement webElement) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,4000)");
        waitForElementToBeClickable(webElement);
        webElement.click();
    }

    protected void scrollToElement(WebElement webElement, int px) {
        // todo: rewrite to optimise the scroll for all screen
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + px + ")");
        // "window.scrollBy(0, 1000)"

//        String xpath11 = "//div[@aria-label='Choose Friday, May 11th, 1990']";
//        String xpath12 = "//div[@aria-label='Choose Friday, May 12th, 1990']";
//        String xpath13 = "//div[@aria-label='Choose Friday, May 13th, 1990']";
//
//        String dateInMayXpath = "//div[@aria-label='Choose Friday, May $idxth, 1990']";
//
//        String eleventhOfMayXpath = dateInMayXpath.replaceAll('$idx',11);
//
//        String s1 = "aaa";
//        String s2 = "bbb";
//        String s3 = "ccc";
//
//        String concatenated1 = s1 + s2 + s3;
//
//        System.out.println("My s1" + s1 );
//        System.out.println("My s1 " + s1 + " " + s2); // > My s1 aaa s2 bbb

        waitForElementToBeClickable(webElement);
    }

    protected void scrollToElementAndClick(WebElement webElement, int px) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,"+ px + ")");
        waitForElementToBeClickable(webElement);
        webElement.click();

    }

    protected WebElement waitForElementToBeClickable(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        return webElement;
    }

    protected WebElement waitForElementToBeVisible(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement;
    }

    protected void waitForAlert() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.alertIsPresent());
    }
}
