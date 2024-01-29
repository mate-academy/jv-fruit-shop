package core.basesyntax.operations;

import java.util.Arrays;

public enum Operation {
    RETURN("r"),
    BALANCE("b"),
    PURCHASE("p"),
    SUPPLY("s");

    private String code;
    Operation(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static Operation getByCode(String code) {
        return Arrays.stream(Operation.values())
                .filter(o -> o.getCode().equals(code))
                .findFirst()
                .get();
    }
}
