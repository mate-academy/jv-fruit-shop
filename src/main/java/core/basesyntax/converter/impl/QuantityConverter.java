package core.basesyntax.converter.impl;

import core.basesyntax.converter.Convertor;

public class QuantityConverter implements Convertor<Integer> {
    @Override
    public Integer convertor(String string) {
        try {
            if (!string.isEmpty()) {
                return Integer.decode(string);
            }
        } catch (NumberFormatException n) {
            throw new RuntimeException("Failed to convert string to Integer: " + string);
        }
        return null;
    }
}
