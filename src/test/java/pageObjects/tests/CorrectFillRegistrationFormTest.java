package pageObjects.tests;


import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pageObjects.components.ResultModalWindow;
import pageObjects.pages.StudentRegistrationFormPage;
import pageObjects.testData.enums.City;
import pageObjects.testData.enums.States;

import java.util.Locale;

import static pageObjects.testData.TestData.*;
import static pageObjects.utils.RandomUtils.getRandomGender;

public class CorrectFillRegistrationFormTest extends BaseTest {

    private StudentRegistrationFormPage studentRegistrationFormPage = new StudentRegistrationFormPage();
    private ResultModalWindow resultModalWindow = new ResultModalWindow();

    @Test
    public void successfulFillForm() {
        Faker faker = new Faker(Locale.forLanguageTag("pl"));

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String gender = getRandomGender();
        String phoneNumber = faker.phoneNumber().subscriberNumber(10);
        String birthMonth = getRandomMonth();
        String birthYear = getRandomYear();
        String birthDay = getRandomDay();
        String subject = getRandomSubject();
        String hobby = getRandomHobby();
        String picturePathAndName = getPicturePathAndName();
        String address = faker.address().streetAddress();
        States state = getRandomState();
        City city = getCityForState(state);


        studentRegistrationFormPage.openPageWithClosingBottomAds()
                .setName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .clickGenderLabel(gender)
                .setUserPhoneNumber(phoneNumber)
                .openCalendar()
                .chooseBirthDate(birthMonth, birthYear, birthDay)
                .setSubject(subject)
                .setHobby(hobby)
                .uploadPicture(picturePathAndName)
                .setCurrentAddress(address)
                .openDropdown("Select State")
                .chooseOptionInStateCityDropdown(state.getValue())
                .openDropdown("Select City")
                .chooseOptionInStateCityDropdown(city.getValue())
                .clickSubmitBtn();

        resultModalWindow.checkModalWindowIsVisible()
                .checkRowHasResult("Student Name", firstName + " " + lastName)
                .checkRowHasResult("Student Email", email)
                .checkRowHasResult("Gender", gender)
                .checkRowHasResult("Mobile", phoneNumber)
                .checkRowHasResult("Date of Birth", birthDay + " " + birthMonth + "," + birthYear)
                .checkRowHasResult("Subjects", subject)
                .checkRowHasResult("Hobbies", hobby)
                .checkRowHasResult("Picture", picturePathAndName)
                .checkRowHasResult("Address", address)
                .checkRowHasResult("State and City", state + " " + city);
    }
}