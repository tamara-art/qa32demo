package demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewWindowPage extends BasePage{
    public NewWindowPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "sampleHeading")
    WebElement sampleHeadingText;
    public String getSampleHeadingText() {
        return sampleHeadingText.getText();
    }
}
