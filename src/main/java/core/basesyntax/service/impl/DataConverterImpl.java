package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int EXPECTED_PARTS_LENGTH = 3;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> data) {
        if (data.isEmpty()) {
            throw new IllegalArgumentException("Data list is empty");
        }

        List<FruitTransaction> transactions = new ArrayList<>();

        List<String> linesWithoutHeader = data.subList(1, data.size());

        for (String line : linesWithoutHeader) {
            String[] parts = line.split(",");
            if (parts.length != EXPECTED_PARTS_LENGTH) {
                throw new IllegalArgumentException("Invalid data format");
            }
            FruitTransaction.Operation operation;
            try {
                operation = FruitTransaction.Operation.fromCode(parts[OPERATION_INDEX].trim());
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid operation type in data: "
                        + parts[OPERATION_INDEX].trim(), e);
            }

            String fruit = parts[FRUIT_INDEX].trim();

            int quantity;
            try {
                quantity = Integer.parseInt(parts[QUANTITY_INDEX].trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid quantity format in data: "
                        + parts[QUANTITY_INDEX].trim(), e);
            }

            transactions.add(new FruitTransaction(operation, fruit, quantity));
        }

        return transactions;
    }
}
