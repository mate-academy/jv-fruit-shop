package core.basesyntax.shop.service;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Items {
    APPLE,
    BANANA,
    PEAR;

    public static String getItemsForValidation() {
        return Arrays.stream(Items.values())
                .map(Enum::name)
                .collect(Collectors.joining("|"));
    }
}
