package demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ButtonsPage extends BasePage{
    @FindBy(id = "doubleClickBtn")
    WebElement doubleClickBtn;
    public ButtonsPage(WebDriver driver) {
        super(driver);
    }

    public ButtonsPage goToWithURL() {
        driver.get("https://demoqa.com/buttons");
        waitForElementToBeClickable(doubleClickBtn);
        return this;
    }

    public ButtonsPage doubleClickOnDoubleClickBtn() {
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickBtn).perform();
        return this;
    }

    @FindBy(id = "rightClickMessage")
    WebElement rightClickText;
    public String getRightClickText() {
        waitForElementToBeVisible(rightClickText);
        return rightClickText.getText();
    }

    @FindBy(id = "doubleClickMessage")
    WebElement doubleClickText;
    public String getDoubleClickText() {
        waitForElementToBeVisible(doubleClickText);
        return doubleClickText.getText();
    }

    @FindBy(id = "rightClickBtn")
    WebElement rightClickBtn;
    public ButtonsPage rightClickOnRightClickBtn() {
        Actions actions = new Actions(driver);
        actions.contextClick(rightClickBtn).perform();
        return this;
    }
}
