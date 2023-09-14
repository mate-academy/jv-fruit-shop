package model;

public enum OperationType {
    BALANCE("b"),

    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r"),

    ALL_TYPES("bspr");

    private final String name;

    OperationType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

