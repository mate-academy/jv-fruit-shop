package core.basesyntax.model;

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

    public static Operation getType(String type) {
        return Arrays
                .stream(values())
                .filter(s -> s.code.equals(type))
                .findFirst().orElseThrow(() -> new RuntimeException("No such code transaction"));
    }

}
