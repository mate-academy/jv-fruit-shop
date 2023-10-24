package core.basesyntax.model;

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

    public String getCodeOfOperation() {
        return code;
    }

    public static Operation getOperationOf(String letter) {
        return Arrays.stream(Operation.values())
                .filter(o -> o.getCodeOfOperation().equals(letter))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("There is no such operation by letter "
                        + "'" + letter + "'"));
    }
}
