package core.basesyntax;

public enum Operations {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r"),
    NOT_FOUND("Not found");

    private String title;

    Operations(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public static Operations getOperations(String title) {
        for (Operations operations : Operations.values()) {
            if (operations.title.equals(title)) {
                return operations;
            }
        }
        return NOT_FOUND;
    }
}

