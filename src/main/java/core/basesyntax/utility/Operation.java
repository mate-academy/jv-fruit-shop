package core.basesyntax.utility;

import java.util.Arrays;
import java.util.NoSuchElementException;

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

    public static Operation getByValue(String operationFirstLetter) {
        return Arrays.stream(Operation.values())
                .filter(operation -> operation.getCode().equals(operationFirstLetter))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }
}
