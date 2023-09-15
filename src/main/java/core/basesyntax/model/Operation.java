package core.basesyntax.model;

import java.util.Arrays;
import java.util.Objects;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String operationAbbreviation;

    Operation(String operationAbbreviation) {
        this.operationAbbreviation = operationAbbreviation;
    }

    public static Operation getByAbbreviation(String operationAbbreviation) {
        return Arrays.stream(Operation.values())
                .filter(e -> Objects.equals(e.operationAbbreviation, operationAbbreviation))
                .findFirst()
                .orElseThrow(
                        () -> new RuntimeException(
                                "There's no such an operation available: " + operationAbbreviation)
                );
    }
}
