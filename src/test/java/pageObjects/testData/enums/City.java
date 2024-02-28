package pageObjects.testData.enums;

public enum City {
    AGRA("Agra"),
    DELHI("Delhi"),
    GURGAON("Gurgaon"),
    JAIPUR("Jaipur"),
    JAISELMER("Jaiselmer"),
    KARNAL("Karnal"),
    LUCKNOW("Lucknow"),
    MEERUT("Meerut"),
    NOIDA("Noida"),
    PANIPAT("Panipat");

    private String displayName;

    City(String displayName) {
        this.displayName = displayName;
    }

    public String getValue() {
        return displayName;
    }
}