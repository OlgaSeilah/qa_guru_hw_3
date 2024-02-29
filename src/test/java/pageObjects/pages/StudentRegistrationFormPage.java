package pageObjects.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pageObjects.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormPage {

    private CalendarComponent calendarComponent = new CalendarComponent();
    private final SelenideElement formHeaderText = $(".practice-form-wrapper h5"),
            firstNameInput = $("input#firstName"),
            lastNameInput = $("input#lastName"),
            userEmailInput = $("#userEmail-wrapper input"),
            genderRadioBtnLabel = $("#genterWrapper"),
            userPhoneNumber = $("input#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsContainerInput = $("#subjectsContainer input"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPictureInput = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            optionInStateDropdown = $("#react-select-3-option-0"),
            optionInCityDropdown = $("#react-select-4-option-0"),
            submitBtn = $("#submit");

    private final ElementsCollection dropdowns = $$("#stateCity-wrapper .css-1wa3eu0-placeholder"),
            statesCitiesOptions = $$(".css-11unzgr div"),
            hobbyCheckboxes = $$(".custom-checkbox");


    public StudentRegistrationFormPage openPageWithClosingBottomAds() {
        open("/automation-practice-form");

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        formHeaderText.shouldHave(text("Student Registration Form"));

        return this;
    }

    public StudentRegistrationFormPage setName(String name) {
        firstNameInput.setValue(name);

        return this;
    }

    public StudentRegistrationFormPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);

        return this;
    }

    public StudentRegistrationFormPage setEmail(String email) {
        userEmailInput.setValue(email);

        return this;
    }

    public StudentRegistrationFormPage clickGenderLabel(String gender) {
        genderRadioBtnLabel.$(byText(gender)).click();

        return this;
    }

    public StudentRegistrationFormPage setUserPhoneNumber(String phoneNumber) {
        userPhoneNumber.setValue(phoneNumber);

        return this;
    }

    public StudentRegistrationFormPage openCalendar() {
        dateOfBirthInput.click();

        return this;
    }

    public StudentRegistrationFormPage chooseBirthDate(String birthMonth, String birthYear, String birthDay) {
        calendarComponent.selectMonth(birthMonth)
                .selectYear(birthYear)
                .selectDay(birthDay);

        return this;
    }

    public StudentRegistrationFormPage setSubject(String subject) {
        subjectsContainerInput.setValue(subject).pressEnter();

        return this;
    }

    public StudentRegistrationFormPage setHobby(String hobby) {
        hobbyCheckboxes.findBy(text(hobby)).click();

        return this;
    }

    public StudentRegistrationFormPage uploadPicture(String picturePath) {
        uploadPictureInput.uploadFromClasspath(picturePath);

        return this;
    }

    public StudentRegistrationFormPage setCurrentAddress(String address) {
        currentAddressInput.setValue(address);

        return this;
    }

    public StudentRegistrationFormPage openDropdown(String dropdownLabel) {
        dropdowns.findBy(text(dropdownLabel))
                .scrollIntoView(false)
                .click();

        return this;
    }

    public StudentRegistrationFormPage chooseOptionInStateDropdown() {
        optionInStateDropdown.click();


        return this;
    }

    public StudentRegistrationFormPage chooseOptionInCityDropdown() {
        optionInCityDropdown.click();


        return this;
    }

    public StudentRegistrationFormPage chooseOptionInStateCityDropdown(String value) {
        statesCitiesOptions.findBy(text(value)).scrollIntoView(false).click();

        return this;
    }

    public StudentRegistrationFormPage clickSubmitBtn() {
        submitBtn.click();

        return this;
    }
}