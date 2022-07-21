package core.basesyntax.model;

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

    public static Operation fromLetter(String letter) {
        return Arrays.stream(Operation.values())
                .filter(v -> v.letter.equals(letter))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Can't find an operation by letter: "
                                                        + letter));
    }
}
