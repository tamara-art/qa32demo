package demo.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ACFramesPage extends BasePage{
    public ACFramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "frame1")
    WebElement iFrame1;


    public void goWithURL() {
        driver.get("https://www.play1.automationcamp.ir/frames.html");
        waitForElementToBeVisible(iFrame1);
    }

    public ACFrame1Page switchToFrame1() {
        driver.switchTo().frame(iFrame1);
        return new ACFrame1Page(driver);
    }

    @FindBy(xpath = "//iframe")
    List<WebElement> iframesList;
    public ACFrame1Page switchToFrame1ById() {
        System.out.println("Number of iFrames in the context of ACFramesPage class (frames.html): " + iframesList.size());

        JavascriptExecutor js = (JavascriptExecutor) driver;
        Integer numberOfiFrames = Integer.parseInt(js.executeScript("return window.length").toString());

        System.out.println("Number of iFrames using JavascriptExecutor: " + js.executeScript("return window.length"));
        System.out.println("Number of iFrames using JavascriptExecutor (parced number): " + numberOfiFrames);

        driver.switchTo().frame(0);
        return new ACFrame1Page(driver);
    }
}
