package demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ACExpectedConditionsPage extends BasePage{
    @FindBy(id = "alert_trigger")
    WebElement showAlertBtn;

    public ACExpectedConditionsPage(WebDriver driver) {
        super(driver);
    }

    public ACExpectedConditionsPage goWithURL() {
        driver.get("https://www.play1.automationcamp.ir/expected_conditions.html");
        waitForElementToBeClickable(showAlertBtn);
        return this;
    }

    public ACExpectedConditionsPage interactWithShowAlert() {
        showAlertBtn.click();
        waitForAlert(5);
        driver.switchTo().alert().accept();
        return this;
    }

    @FindBy(id = "alert_handled_badge")
    WebElement alertHandledBadge;
    public String getAlertHandledBageText() {
        return waitForElementToBeVisible(alertHandledBadge).getText();
    }

    @FindBy(id = "prompt_trigger")
    WebElement showPromptBtn;
    public ACExpectedConditionsPage acceptPromptAlert() {
        showPromptBtn.click();
        waitForAlert(5);
        driver.switchTo().alert().accept();
        return this;
    }

    @FindBy(id = "prompt_trigger")
    WebElement showCancelBtn;
    public ACExpectedConditionsPage dismissPromptAlert() {
        showCancelBtn.click();
        waitForAlert(5);
        driver.switchTo().alert().dismiss();
        return this;
    }

    @FindBy(id = "confirm_ok_badge")
    WebElement promptAcceptedHandledBadge;
    public String getPromtHandledBageText() {
        return waitForElementToBeVisible(promptAcceptedHandledBadge).getText();
    }
}
