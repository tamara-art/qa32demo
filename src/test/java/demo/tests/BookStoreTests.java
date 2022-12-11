package demo.tests;

import demo.pages.BookStorePage;
import demo.pages.LoginPage;
import demo.pages.MenuSideBar;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookStoreTests extends BaseTests{
    @BeforeMethod
    public void ensurePreconditions() {
        new LoginPage(driver).login("User2467", "Zxdc4567*").waitToLoad();
    }

    @Test
    public void searchFormTestPositive() {
        String searchText = "JS";
        String expectedBookName = "You Don't Know JS";
        System.out.println("searchFormTestPositive...");
        new MenuSideBar(driver)
                .clickOnBookStoreMenu()
                .typeTextIntoSearchField(searchText);

        String actualBookName = new BookStorePage(driver).getBookName(0);
        Assert.assertEquals(actualBookName, expectedBookName, "Expected book name: " + expectedBookName);
    }

    //HW #1: Implement a TC: look for "JavaScript" and check all 4 books are there; check the name of each book returned

    @Test
    public void addToCollectionPositive() {
        String searchText = "JS";
        String expectedBookName = "You Don't Know JS";

        new MenuSideBar(driver)
                .clickOnBookStoreMenu()
                .typeTextIntoSearchField(searchText);

        new BookStorePage(driver)
                .clickOnBookName(expectedBookName)
                .addToCollection()
                // if you have an Alert:
                .closeTheAlert()
        ;

        // HW #2: extend the TC: go to Profile; check that out of all the book there is one that you've added
        // HW #3: extend the TC: remove the item from your collection
        // HW #4: add me to the contributors in your git repo (akutafina)
    }
}
