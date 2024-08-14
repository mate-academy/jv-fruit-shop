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

        for (String line: linesWithoutHeader) {
            String[] parts = line.split(",");
            if (parts.length != EXPECTED_PARTS_LENGTH) {
                throw new IllegalArgumentException("Invalid data format");
            }
            FruitTransaction.Operation operation = FruitTransaction
                    .Operation.fromCode(parts[OPERATION_INDEX]);
            String fruit = parts[FRUIT_INDEX];
            int quantity = Integer.parseInt(parts[QUANTITY_INDEX]);
            transactions.add(new FruitTransaction(operation, fruit, quantity));

        }
        return transactions;
    }
}
