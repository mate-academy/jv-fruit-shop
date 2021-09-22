package core.basesyntax.model;

import java.util.Arrays;

public enum OperationType {
    BALANCE("b"),
    PURCHASE("p"),
    SUPPLY("s"),
    RETURN("r");
    private final String operator;

    OperationType(String operator) {
        this.operator = operator;
    }

    public static OperationType getEnumValue(String operator) {
        return Arrays.stream(OperationType.values())
                .filter(ot -> ot.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Can`t find operation type such as "
                        + operator));
    }
}
