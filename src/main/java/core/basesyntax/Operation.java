package core.basesyntax;

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

    public static Operation getOperations(String title) {
        return Arrays.stream(Operation.values())
                .filter(op -> op.getTitle().equals(title))
                .findAny()
                .orElseThrow(RuntimeException::new);
    }
}

