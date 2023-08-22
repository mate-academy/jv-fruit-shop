package core.basesyntax.model;

import java.util.Arrays;
import java.util.Optional;

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

    public static Operation getByCode(String code) {
        Optional<Operation> operation = Arrays.stream(values())
                .filter(o -> o.getCode().equals(code))
                .findFirst();

        return operation.orElseThrow(() -> new RuntimeException("Wrong operation code - " + code));
    }
}
