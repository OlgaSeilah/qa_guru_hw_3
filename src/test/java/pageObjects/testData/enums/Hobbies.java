package pageObjects.testData.enums;

public enum Hobbies {
    READING("Reading"),
    SPORTS("Sports"),
    MUSIC("Music");

    private String value;

    Hobbies(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}