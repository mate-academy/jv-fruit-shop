package service;

import java.util.List;
import java.util.stream.Collectors;
import model.FruitTransaction;

public class DataConverterImpl implements DataConverter {
    private static final String CSV_SEPARATOR = ",";
    private static final int TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String HEADER = "type,fruit,quantity";

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> lines) {
        return lines.stream()
                .filter(line -> !line.trim().isEmpty() && !line.startsWith(HEADER))
                .map(this::parseLine)
                .collect(Collectors.toList());
    }

    private FruitTransaction parseLine(String line) {
        String[] parts = line.split(CSV_SEPARATOR);
        if (parts.length < 3) {
            throw new IllegalArgumentException("Invalid CSV line format: " + line);
        }

        FruitTransaction.Operation operation =
                FruitTransaction.Operation.getByCode(parts[TYPE_INDEX].trim());
        String fruit = parts[FRUIT_INDEX].trim();
        int quantity = Integer.parseInt(parts[QUANTITY_INDEX].trim());

        return new FruitTransaction(operation, fruit, quantity);
    }
}
