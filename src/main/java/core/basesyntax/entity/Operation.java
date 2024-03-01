package core.basesyntax.entity;

import java.util.Arrays;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r"),
    UTILIZATION("u");

    private String code;

    Operation(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static Operation chooseOperation(String code) {
        return Arrays.stream(Operation.values())
                .filter(operation -> operation.getCode().equals(code))
                .findFirst()
                .get();
    }
}