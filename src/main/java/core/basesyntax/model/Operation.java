package core.basesyntax.model;

public enum Operation {
    BALANCE("b", "Balance"),
    PURCHASE("p", "Purchase"),
    RETURN("r", "Return"),
    SUPPLY("s", "Supply");

    private final String abbreviation;
    private final String fullName;

    Operation(String abbreviation, String fullName) {
        this.abbreviation = abbreviation;
        this.fullName = fullName;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getFullName() {
        return fullName;
    }
}
