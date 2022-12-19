package demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ACFrame1Page extends BasePage{
    @FindBy(id = "frame2")
    WebElement iFrame2;

    @FindBy(id = "frame3")
    WebElement iFrame3;

//    @FindBy(id = "frame4")
//    WebElement iFrame4;

    public ACFrame1Page(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "click_me_1")
    WebElement btn1;
    public ACFrame1Page clickOnBtn1() {
        waitForElementToBeClickable(btn1);
        btn1.click();
        return this;
    }

    public ACFrame2Page switchToFrame2() {
        driver.switchTo().frame(iFrame2);
        return new ACFrame2Page(driver);
    }
}
