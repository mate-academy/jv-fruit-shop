package core.basesyntax.model.fruit;

import java.util.NoSuchElementException;
import java.util.stream.Stream;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String value;

    Operation(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Operation getOperationFromString(String operation) {
        return Stream.of(Operation.values())
                .filter(o -> o.getValue().equals(operation))
                .findFirst()
                .orElseThrow(()
                        -> new NoSuchElementException(operation + " operation is not supported"));
    }
}
