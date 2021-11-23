package core.basesyntax.shop.service;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Operations {
    B,
    S,
    P,
    R;

    public static String operationsString() {
        return Arrays.stream(Operations.values())
                .map(e -> e.name().toLowerCase())
                .collect(Collectors.joining());
    }
}
