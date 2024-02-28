package pageObjects.testData.enums;

public enum Genders {
    FEMALE("Female"),
    MALE("Male"),
    OTHER("Other");

    private String gender;

    Genders(String gender) {
        this.gender = gender;
    }

    public String getValue() {
        return this.gender;
    }
}