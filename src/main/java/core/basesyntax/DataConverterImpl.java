package core.basesyntax;

import java.util.List;
import java.util.stream.Collectors;
import model.FruitTransaction;
import model.Operation;

public class DataConverterImpl implements DataConverter {
    private static final String LINE_SEPARATOR = ",";
    private static final int MAX_LINE_FORMAT = 3;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> lines) {
        return lines.stream()
                .map(this::parseLine)
                .collect(Collectors.toList());
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
