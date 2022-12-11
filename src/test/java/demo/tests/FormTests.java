package demo.tests;

import demo.data.Student;
import demo.pages.FormPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FormTests extends BaseTests{
    @BeforeMethod
    public void ensurePreconditions(){
        new FormPage(driver).navigateWithURL();
    }

    @Test
    public void testStudentRegistrationFormPositive(){
        // todo: add Data Provider from file
        Student validStudent = new Student("Test First Name",
                "Test Last Name",
                "test@email.com",
                Student.Gender.MALE,
                "1234567890" ,
                "11 May 1990",
                "src/test/testdata/photo.jpeg");

        new FormPage(driver)
                .enterFirstName(validStudent.getFirstName())
                .enterLastName(validStudent.getLastName())
                .enterEmail(validStudent.getEmail())
                .selectGender(validStudent.getGender())
                .enterPhoneNumber(validStudent.getPhone())
                .enterDateOfBirth(validStudent.getDateOfBirth())
                .uploadPicture(validStudent.getPictureLink());
    }
}
