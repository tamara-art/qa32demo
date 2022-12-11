package demo.pages;

import demo.data.Student;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FormPage extends BasePage{
    @FindBy(id = "firstName")
    WebElement firstNameField;

    @FindBy(id = "lastName")
    WebElement lastNameField;

    @FindBy(id = "userNumber")
    WebElement phoneNumberField;

    @FindBy(id = "userEmail")
    WebElement userEmailField;

    @FindBy(xpath = "//label[@for='gender-radio-1']")
    WebElement maleGenderRadioBtn;

    @FindBy(xpath = "//label[@for='gender-radio-2']")
    WebElement femaleGenderRadioBtn;

    @FindBy(xpath = "//label[@for='gender-radio-3']")
    WebElement otherGenderRadioBtn;

    public static final String STUDENT_REGISTRATION_FORM_URL = "https://demoqa.com/automation-practice-form";

    public FormPage(WebDriver driver) {
        super(driver);
    }

    public void navigateWithURL() {
        driver.get(STUDENT_REGISTRATION_FORM_URL);
        waitForElementToBeClickable(firstNameField);
    }

    public FormPage enterFirstName(String firstName) {
        type(firstNameField,firstName);
        return this;
    }

    public FormPage enterLastName(String lastName) {
        type(lastNameField,lastName);
        return this;
    }

    public FormPage enterPhoneNumber(String phone) {
        type(phoneNumberField,phone);
        return this;
    }

    public FormPage enterEmail(String email) {
        type(userEmailField,email);
        return this;
    }

    public FormPage selectGender(Student.Gender gender) {
// Bad example:
//        if(gender == Student.Gender.MALE){
//            maleGenderRadioBtn.click();
//        } else if (gender == Student.Gender.FEMALE) {
//            femaleGenderRadioBtn.click();
//        } else{
//            otherGenderRadioBtn.click();
//        }

        switch(gender) {
            case MALE:
                maleGenderRadioBtn.click(); break;
            case FEMALE:
                femaleGenderRadioBtn.click(); break;
            case OTHER:
                otherGenderRadioBtn.click();break;
            default:
                // optionally throw exception
        }
        return this;
    }


    @FindBy(id = "dateOfBirthInput")
    WebElement dateOfBirthField;

    @FindBy(className = "react-datepicker__year-select")
    WebElement yearDropDown;

    @FindBy(className = "react-datepicker__month-select")
    WebElement monthDropDown;

    @FindBy(className = "react-datepicker__day")
    List<WebElement> dateCells;

    public FormPage enterDateOfBirth(String dateOfBirth) {
        //clearAndType(dateOfBirthField,dateOfBirth);

        String[] dateOfBirthArray = dateOfBirth.split(" ");

        waitForElementToBeClickable(dateOfBirthField);
        dateOfBirthField.click();

        Select yearSelector = new Select(yearDropDown);
        yearSelector.selectByVisibleText(dateOfBirthArray[2]);

        waitForElementToBeClickable(monthDropDown);
        monthDropDown.click();

        Select monthSelector = new Select(monthDropDown);
        monthSelector.selectByVisibleText(dateOfBirthArray[1]);

        dateCells.stream()
                .filter(dateCell -> dateCell.getAttribute("aria-label").contains(dateOfBirthArray[1] + " " + dateOfBirthArray[0]))
                .findFirst()
                .get()
                .click();
        return this;
    }


    @FindBy(id = "uploadPicture")
    WebElement uploadPictureBtn;
    public FormPage uploadPicture(String pictureLink) {
        scrollToElement(uploadPictureBtn,400);
        //todo: most likely will work:)
        uploadPictureBtn.sendKeys(pictureLink);
        return this;
    }
}
