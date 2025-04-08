package core.basesyntax.converter;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final int FIRST_LINE_SKIP = 1;
    private static final String LINE_SEPARATOR = ",";
    private static final int MAX_LINE_FORMAT = 3;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> lines) {
        return lines.stream()
                .skip(FIRST_LINE_SKIP)
                .map(this::parseLine)
                .toList();
    }

    private FruitTransaction parseLine(String line) {
        String[] parts = line.split(LINE_SEPARATOR);
        if (parts.length != MAX_LINE_FORMAT) {
            throw new IllegalArgumentException("Invalid line format " + line);
        }

        Operation operation = Operation.fromCode(parts[0]);
        String fruit = parts[1];
        int quantity;

        try {
            quantity = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid quantity value : " + parts[2]);
        }
        return new FruitTransaction(operation, fruit, quantity);
    }
}
