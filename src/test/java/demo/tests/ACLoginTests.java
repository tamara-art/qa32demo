package demo.tests;

import demo.pages.ACLoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ACLoginTests extends BaseTests{
    @BeforeMethod
    public void ensurePreconditions(){
        new ACLoginPage(driver).goWithURL();
    }

    @Test
    public void loginWithKeyboardTestNegative(){
        new ACLoginPage(driver)
                .loginWithKeyboard("test_login", "test_pwd");
    }

    @Test
    public void loginWithKeyboardCopyPasteTestNegative(){
        new ACLoginPage(driver)
                .loginWithKeyboardCopyPaste("test_login");
    }
}
