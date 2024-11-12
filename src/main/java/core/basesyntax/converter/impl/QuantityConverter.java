package core.basesyntax.converter.impl;

import core.basesyntax.converter.Convertor;

public class QuantityConverter implements Convertor<Integer> {
    @Override
    public Integer convertor(String string) {
        try {
            if (string.isEmpty()) {
                throw new RuntimeException("String cannot be empty");
            }
        } catch (NumberFormatException exception) {
            throw new RuntimeException("Failed to convert string to Integer: " + string);
        }
        return Integer.decode(string);
    }
}
