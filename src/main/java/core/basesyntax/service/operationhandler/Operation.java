package core.basesyntax.service.operationhandler;

import java.util.Arrays;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String letter;

    Operation(String letter) {
        this.letter = letter;
    }

    public String getType() {
        return letter;
    }

    public static Operation get(String letter) {
        return Arrays.stream(Operation.values())
                .filter(operation -> operation.getType().contains(letter))
                .findFirst().get();
    }
}
