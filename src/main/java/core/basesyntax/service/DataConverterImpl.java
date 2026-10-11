package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.stream.Collectors;

public class DataConverterImpl implements DataConverter {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int HEADER_LINE_INDEX = 0;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new IllegalArgumentException("Lines list cannot be null or empty");
        }
        return lines.stream()
                .skip(1) // Пропускаємо рядок заголовку (type,fruit,quantity)
                .filter(line -> line != null && !line.isBlank())
                .map(this::parseLineToTransaction)
                .collect(Collectors.toList());
    }

    private FruitTransaction parseLineToTransaction(String line) {
        String[] data = line.split(",");
        if (data.length < 3) {
            throw new IllegalArgumentException("Invalid line format: " + line);
        }
        FruitTransaction.Operation operation =
                FruitTransaction.Operation.fromCode(data[OPERATION_INDEX].trim());
        String fruit = data[FRUIT_INDEX].trim();
        int quantity = Integer.parseInt(data[QUANTITY_INDEX].trim());

        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative: " + quantity);
        }

        return new FruitTransaction(operation, fruit, quantity);
    }
}
