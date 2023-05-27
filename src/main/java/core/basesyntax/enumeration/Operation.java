package core.basesyntax.enumeration;

import java.util.Arrays;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String code;

    Operation(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static Operation getOperation(String string) {
        return Arrays.stream(Operation.values())
                .filter(operation -> operation.getCode().equals(string))
                .findFirst()
                .get();
    }
}
