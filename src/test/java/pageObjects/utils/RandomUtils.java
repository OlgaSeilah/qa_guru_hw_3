package pageObjects.utils;

import java.util.ArrayList;
import java.util.Random;

public class RandomUtils {


    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        int randomIndex = new Random().nextInt(genders.length);

        return genders[randomIndex];
    }



}
