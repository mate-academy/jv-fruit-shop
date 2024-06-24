package core.basesyntax.transaction;

import java.util.Arrays;
import java.util.Objects;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private String code;

    Operation(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static Operation getOperation(String code) {
        return Arrays.stream(Operation.values())
                .filter(operation -> Objects.equals(operation.code, code))
                .distinct()
                .min((o1, o2) -> 0)
                .orElseThrow();
    }
}
