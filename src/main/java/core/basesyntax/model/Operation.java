package core.basesyntax.model;

import core.basesyntax.exception.InvalidDataException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private static final Map<String, Operation> MAP = new HashMap<>();
    private final String code;

    static {
        Arrays.stream(Operation.values())
                .forEach(x -> MAP.put(x.code, x));
    }

    Operation(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static Operation getByCode(String code) {
        return Arrays.stream(values())
                .filter(operation -> operation.getCode().equals(code))
                .findAny()
                .orElseThrow(
                        () -> new InvalidDataException("File has invalid operation type: " + code)
                );
    }
}
