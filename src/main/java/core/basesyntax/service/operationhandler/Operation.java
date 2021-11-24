package core.basesyntax.service.operationhandler;

import java.util.Arrays;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String abbr;

    Operation(String abbr) {
        this.abbr = abbr;
    }

    public String getType() {
        return abbr;
    }

    public static Operation get(String abbr) {
        return Arrays.stream(Operation.values())
                .filter(operation -> operation.getType().contains(abbr))
                .findFirst().get();
    }
}
