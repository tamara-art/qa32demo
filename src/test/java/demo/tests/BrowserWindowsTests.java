package demo.tests;

import demo.pages.BrowserWindowsPage;
import demo.tests.BaseTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserWindowsTests extends BaseTests {
    @BeforeMethod
    public void ensurePreconditions() {
        new BrowserWindowsPage(driver).goToWithURL();
    }

    @Test
    public void openNewTabTestPositive(){
        String actualSampleHeadingText = new BrowserWindowsPage(driver)
                .clickOnNewTabBtn()
                .getSampleHeadingText();

        Assert.assertEquals(actualSampleHeadingText, "This is a sample page",
                "Actual heading text is: " + actualSampleHeadingText);
    }


    @Test
    public void openNewWindowTestPositive(){
        String actualSampleHeadingText = new BrowserWindowsPage(driver)
                .clickOnNewWindowBtn()
                .getSampleHeadingText();

        Assert.assertEquals(actualSampleHeadingText, "This is a sample page",
                "Actual heading text is: " + actualSampleHeadingText);
    }

    //HW: add test for 'New Window Message' btn
}
