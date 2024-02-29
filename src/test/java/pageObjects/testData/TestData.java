package pageObjects.testData;

import com.github.javafaker.Faker;
import pageObjects.testData.enums.*;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.String.valueOf;
import static java.util.Locale.forLanguageTag;

public class TestData {

    public static String getFirstName() {
        return new Faker(forLanguageTag("pl")).name().firstName();
    }

    public static String getLastName() {
        return new Faker(forLanguageTag("pl")).name().lastName();
    }

    public static String getEmail() {
        return new Faker().internet().emailAddress();
    }

    public static String getGender() {
        Random random = new Random();
        Genders[] genders = Genders.values();
        return genders[random.nextInt(genders.length)].getValue();
    }
    public static String getPhoneNumber(int countOfNumbersInPhone) {
        return new Faker()
                .phoneNumber()
                .subscriberNumber(countOfNumbersInPhone);
    }

    public static String getAddress() {
        return new Faker(forLanguageTag("pl"))
                .address()
                .fullAddress();
    }

    public static States getRandomState() {
        Random random = new Random();
        States[] states = States.values();
        return states[random.nextInt(states.length)];
    }

    public static City getCityForState(States state) {
        City[] cities;
        switch (state) {
            case NCR:
                cities = new City[] {City.DELHI, City.GURGAON, City.NOIDA};
                break;
            case UTTAR_PRADESH:
                cities = new City[] {City.LUCKNOW, City.AGRA, City.MEERUT};
                break;
            case HARYANA:
                cities = new City[] {City.KARNAL, City.PANIPAT};
                break;
            case RAJASTHAN:
                cities = new City[] {City.JAIPUR, City.JAISELMER};
                break;
            default:
                throw new IllegalArgumentException("Unknown state: " + state);
        }
        Random random = new Random();
        return cities[random.nextInt(cities.length)];
    }

    public static String getRandomHobby() {
        Hobbies[] hobbies = Hobbies.values();
        Random random = new Random();
        return hobbies[random.nextInt(hobbies.length)].getValue();
    }

    public static String getRandomSubject() {
        Subjects[] subjects = Subjects.values();
        Random random = new Random();
        return subjects[random.nextInt(subjects.length)].getValue();
    }

    public static String getRandomMonth() {
        Month[] months = Month.values();
        Random random = new Random();
        return months[random.nextInt(months.length)].getValue();
    }

    public static String getRandomYear() {
        return Integer.toString(ThreadLocalRandom.current().nextInt(1923, 2023));
    }

    public static String getRandomDay() {
        int day = ThreadLocalRandom.current().nextInt(1, 27);
        return  valueOf(day);

    }

    public static String getPicturePathAndName() {
        return "leaves.jpg";
    }
}
