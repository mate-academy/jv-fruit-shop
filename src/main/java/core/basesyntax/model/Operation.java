package core.basesyntax.model;

import core.basesyntax.model.exception.InvalidDataException;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private static final Map<String, Operation> MAP;
    private String code;

    static {
        MAP = Arrays.stream(values())
                .collect(Collectors.toMap(Operation::getCode, operation -> operation));
    }

    Operation(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static Operation of(String code) {
        try {
            return MAP.get(code);
        } catch (Exception e) {
            throw new InvalidDataException("Invalid operation type: " + code);
        }
    }
}
