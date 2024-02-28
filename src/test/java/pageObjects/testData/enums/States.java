package pageObjects.testData.enums;

public enum States {
    NCR("NCR"),
    UTTAR_PRADESH("Uttar Pradesh"),
    HARYANA("Haryana"),
    RAJASTHAN("Rajasthan");

    private String displayName;

    States(String displayName) {
        this.displayName = displayName;
    }

    public String getValue() {
        return displayName;
    }
}