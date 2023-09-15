package core.basesyntax.model;

import core.basesyntax.exception.InvalidDataException;
import java.util.Arrays;

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

    public static Operation getOperationByCode(String code) {
        return Arrays.stream(Operation.values())
                .filter(n -> n.getCode().equals(code))
                .findFirst()
                .orElseThrow(
                        () -> new InvalidDataException("File has invalid operation type: " + code));
    }
}
