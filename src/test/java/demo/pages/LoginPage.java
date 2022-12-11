package demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    @FindBy(id = "userName")
    WebElement userNameField;

    @FindBy(id = "password")
    WebElement pwdField;

    @FindBy(id = "login")
    WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public ProfilePage login(String userName, String pwd) {
        type(userNameField, userName);
        type(pwdField, pwd);
        loginBtn.click();
        return new ProfilePage(driver);
    }
}
