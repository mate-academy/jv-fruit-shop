package core.basesyntax.model;

import java.util.Arrays;
import java.util.stream.Collectors;

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

    public static String getAllAllowedOperationTypes() {
        return Arrays.stream(values())
                .map(Operation::getCode)
                .collect(Collectors.joining(", "));
    }
}
