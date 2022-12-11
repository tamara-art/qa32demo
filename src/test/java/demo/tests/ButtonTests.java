package demo.tests;

import demo.pages.ButtonsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonTests extends BaseTests{
    @BeforeMethod
    public void ensurePreconditions() {
        new ButtonsPage(driver).goToWithURL();
    }

    @Test
    public void doubleClickTestPositive(){
        String actualDoubleClickMessage = new ButtonsPage(driver)
                .doubleClickOnDoubleClickBtn()
                // bad example:
                //.isTextVisible("You have done a right click")
                .getDoubleClickText();

        Assert.assertEquals(actualDoubleClickMessage, "You have done a double click",
                "Right Click Message is Visible and is: " + actualDoubleClickMessage);

        // bad example:
        //Assert.assertTrue(isTextVisible, "Text is Visible");
    }

    @Test
    public void rightClickTestPositive(){
        String actualRightClickMessage = new ButtonsPage(driver)
                .rightClickOnRightClickBtn()
                .getRightClickText();

        Assert.assertEquals(actualRightClickMessage, "You have done a right click",
                "Right Click Message is Visible and is: " + actualRightClickMessage);
    }
}
