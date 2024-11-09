package core.basesyntax.converter.impl;

import core.basesyntax.converter.Convertor;

public class QuantityConverter implements Convertor<Integer> {
    @Override
    public Integer parseMethod(String string) {
        try {
            if (!string.isEmpty()) {
                return Integer.decode(string);
            }
        } catch (NumberFormatException n) {
            return null;
        }
        return null;
    }
}
