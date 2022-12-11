package demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BookStorePage extends BasePage{
    @FindBy(id = "searchBox")
    WebElement searchBoxField;

    @FindBy(xpath = "//span[@class='mr-2']")
    List<WebElement> bookNamesLinks;

    public BookStorePage(WebDriver driver) {
        super(driver);
    }

    public BookStorePage typeTextIntoSearchField(String searchText) {
        type(searchBoxField, searchText);
        return this;
    }

    public String getBookName(int idx) {
        return bookNamesLinks.get(idx).getText();
    }

    public BookItemPage clickOnBookName(String bookName) {
        bookNamesLinks.stream()
                .filter(webElementLink -> webElementLink.getText().equals(bookName))
                .findFirst()
                .get()
                .click();
        return new BookItemPage(driver);
    }
}
