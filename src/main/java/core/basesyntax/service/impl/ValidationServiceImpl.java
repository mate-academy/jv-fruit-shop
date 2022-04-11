package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class ValidationServiceImpl implements Predicate<String> {
    private String pattern;

    public ValidationServiceImpl() {
        pattern = "[" + getSupportedOperations() + "],\\w+,\\d+";
    }

    @Override
    public boolean test(String line) {
        if (Pattern.matches(pattern, line)) {
            return true;
        }
        throw new RuntimeException("Invalid data line: " + line);
    }

    private String getSupportedOperations() {
        StringBuilder builder = new StringBuilder();
        for (FruitTransaction.Operation operation : FruitTransaction.Operation.values()) {
            builder.append(operation.getOperation());
        }
        return builder.toString();
    }
}
