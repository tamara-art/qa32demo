package demo.tests;

import demo.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTests{
    @Test
    public void loginTestPositive() {
        String currentUserName = "User2467";
        String currentPwd = "Zxdc4567*";

        Assert.assertEquals(
                new LoginPage(driver)
                        .login(currentUserName, currentPwd)
                        .getUserName(),
                currentUserName, "User Name expected is: " + currentUserName);
    }
}
