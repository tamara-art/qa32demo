package demo.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ACLoginPage extends BasePage{
    @FindBy(id = "login")
    WebElement loginBtn;

    public ACLoginPage(WebDriver driver) {
        super(driver);
    }

    public ACLoginPage goWithURL() {
        driver.get("https://www.play1.automationcamp.ir/login.html");
        waitForElementToBeClickable(loginBtn);
        return this;
    }

    public ACLoginPage loginWithKeyboard(String login, String pwd) {
        Actions actions = new Actions(driver);

        //switch to login field
        actions.sendKeys(Keys.TAB).build().perform();
        actions.sendKeys(login).build().perform();

        //switch to pwd field
        actions.sendKeys(Keys.TAB).build().perform();
        actions.sendKeys(pwd).build().perform();

        //switch to Login button
        actions.sendKeys(Keys.TAB).build().perform();
        actions.sendKeys(Keys.ENTER).build().perform();

        return this;
    }

    public ACLoginPage loginWithKeyboardCopyPaste(String login) {

        Actions actions = new Actions(driver);

        //switch to login field
        actions.sendKeys(Keys.TAB).build().perform();
        actions.sendKeys(login).build().perform();
        // select all text
        actions.keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND).build().perform();
        // copy to the buffer
        actions.keyDown(Keys.COMMAND).sendKeys("c").keyUp(Keys.COMMAND).build().perform();

        //switch to pwd field
        actions.sendKeys(Keys.TAB).build().perform();
        //paste from buffer
        actions.keyDown(Keys.COMMAND).sendKeys("v").keyUp(Keys.COMMAND).build().perform();

        //switch to Login button
        actions.sendKeys(Keys.TAB).build().perform();
        actions.sendKeys(Keys.ENTER).build().perform();

        return this;

        // HW: modify code for Windows
    }
}
