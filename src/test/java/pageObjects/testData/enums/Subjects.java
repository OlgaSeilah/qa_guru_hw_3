package pageObjects.testData.enums;

public enum Subjects {
    ENGLISH("English"),
    MATHS("Maths"),
    HISTORY("History"),
    SCIENCE("Science"),
    GEOGRAPHY("Geography");

    private String value;

    Subjects(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
