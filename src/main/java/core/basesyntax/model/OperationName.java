package core.basesyntax.model;

import java.util.Arrays;

public enum OperationName {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String code;

    OperationName(String code) {
        this.code = code;
    }

    public static OperationName getByCode(String code) {
        return Arrays.stream(OperationName.values())
                .filter(o -> o.code.equals(code))
                .findFirst().orElseThrow(() -> new RuntimeException("Invalid code " + code));
    }
}
