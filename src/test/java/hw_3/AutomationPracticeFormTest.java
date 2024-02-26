package hw_3;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormTest {

    @BeforeAll
    static void resolutionAndUrl() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillAndCheckForm() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("someName");
        $("#lastName").setValue("someLastname");
        $("#userEmail").setValue("name@domain.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText("August")).click();
        $(".react-datepicker__year-select").$(byText("1990")).click();
        $(".react-datepicker__month").$(byText("26")).click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("leaves.jpg");
        $("#currentAddress").setValue("Some street, house, 5");
        $("#state").click();
        $("#state").$(byText("Haryana")).click();
        $("#city").click();
        $("#city").$(byText("Panipat")).click();
        $("#submit").click();

        $(".table-responsive").shouldHave(text("someName someLastname"),
                (text("name@domain.com")),
                (text("Male")),
                (text("1234567890")),
                (text("26 August,1990")),
                (text("English")),
                (text("Music")),
                (text("leaves.jpg")),
                (text("Some street, house, 5")),
                (text("Haryana Panipat")));
    }
}
