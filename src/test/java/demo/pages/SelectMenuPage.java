package demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class SelectMenuPage extends BasePage{
    public SelectMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "oldSelectMenu")
    WebElement oldSelectMenuDropdown;
    public SelectMenuPage goToWithURL() {
        driver.get("https://demoqa.com/select-menu");
        waitForElementToBeClickable(oldSelectMenuDropdown);
        return this;
    }

    public SelectMenuPage selectOldStyleSelectMenu(String color) {
        oldSelectMenuDropdown.click();
        Select oldStyleSelectMenu = new Select(oldSelectMenuDropdown);
        oldStyleSelectMenu.selectByVisibleText(color);
        return this;
    }

    @FindBy(xpath = "(//*[@class=' css-2b097c-container'])[3]")
    WebElement multiselectDropDown;

    @FindBy(id = "react-select-4-option-0")
    WebElement greenMultiselectOption;

    @FindBy(id = "react-select-4-option-1")
    WebElement blueMultiselectOption;

    @FindBy(id = "react-select-4-option-2")
    WebElement blackMultiselectOption;

    @FindBy(id = "react-select-4-option-3")
    WebElement redMultiselectOption;

    public SelectMenuPage selectMultiselectDropdown(ArrayList<String> colorsToSelect) {
        scrollToElementAndClick(multiselectDropDown,300);
        for (String color: colorsToSelect) {
            clickOnColor(color);
        }
        return this;
    }

    private void clickOnColor(String color){
        switch (color){
            case "Blue": blueMultiselectOption.click(); break;
            case "Black":  blackMultiselectOption.click(); break;
            // HW: add all other colors
        }
    }
}
