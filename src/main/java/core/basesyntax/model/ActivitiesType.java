package core.basesyntax.model;

public enum ActivitiesType {
    b("balance"),
    p("purchase"),
    r("return"),
    s("supply");

    private String fullName;

    ActivitiesType(String fullName) {
        this.fullName = fullName;
    }

    String getFullName() {
        return fullName;
    }
}
