package core.basesyntax.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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

    public static Optional<Operation> getByCode(String code) {
        return Optional.ofNullable(MAP.get(code.trim()));
    }
}
