package demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage{
    @FindBy(id = "userName-value")
    WebElement userNameText;

    @FindBy(id = "submit")
    WebElement logOutBtn;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public String getUserName() {
        return userNameText.getText();
    }

    public void waitToLoad() {
        System.out.println("Waiting for login form to load ...");
        waitForElementToBeClickable(logOutBtn);
    }
}
