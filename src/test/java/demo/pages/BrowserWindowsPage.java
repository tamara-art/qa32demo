package demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class BrowserWindowsPage extends BasePage{
    @FindBy(id = "tabButton")
    WebElement newTabBtn;
    public BrowserWindowsPage(WebDriver driver) {
        super(driver);
    }

    public BrowserWindowsPage goToWithURL() {
        driver.get("https://demoqa.com/browser-windows");
        waitForElementToBeClickable(newTabBtn);
        return this;
    }

    public NewTabPage clickOnNewTabBtn() {
        newTabBtn.click();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return new NewTabPage(driver);
    }

    @FindBy(id = "windowButton")
    WebElement newWindowButton;
    public NewWindowPage clickOnNewWindowBtn() {
        newWindowButton.click();
        ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));
        return new NewWindowPage(driver);
    }
}
