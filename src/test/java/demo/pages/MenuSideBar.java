package demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuSideBar extends BasePage{
    @FindBy(xpath = "//li[contains(@class,'btn btn-light')]/*[text()='Book Store']")
    WebElement bookStoreMenu;

    public MenuSideBar(WebDriver driver) {
        super(driver);
    }

    public BookStorePage clickOnBookStoreMenu() {
        scrollToElementAndClick(bookStoreMenu);
        // bookStoreMenu.click(); - won't work coz is out the viewport
        return new BookStorePage(driver);
    }

}
