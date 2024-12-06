package core.basesyntax;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private String title;

    Operation(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public static Operation getOperations(String title) {
        for (Operation operations : Operation.values()) {
            if (operations.title.equals(title)) {
                return operations;
            }
        }
        return null;
    }
}

