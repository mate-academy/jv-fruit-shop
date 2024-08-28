package core.basesyntax.model.enums;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String code;

    Operation(String code) {
        this.code = code;
    }

    public static Operation fromCode(String code) {
        return Arrays.stream(values())
                .filter(operation -> operation.code.equals(code))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Operation with code = ["
                        + code + "] not found"));
    }

    public String getCode() {
        return code;
    }
}
