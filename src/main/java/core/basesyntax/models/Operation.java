package core.basesyntax.models;

import java.util.Arrays;

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

    public static Operation getOperation(String title) {
        return Arrays.stream(Operation.values())
                .filter(operation -> operation.getTitle().equals(title))
                .findAny()
                .orElseThrow(()
                        -> new RuntimeException("Invalid operation, check the title of operation"));
    }
}
