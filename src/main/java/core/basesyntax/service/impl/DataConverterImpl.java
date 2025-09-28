package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String DELIMITER = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int EXPECTED_PARTS_COUNT = 3;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = 0; i < inputReport.size(); i++) {
            String line = inputReport.get(i);
            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split(DELIMITER);
            if (parts.length != EXPECTED_PARTS_COUNT) {
                throw new IllegalArgumentException(
                        "Invalid line format at line " + (i + 1) + ": expected 3 parts, got "
                                + parts.length);
            }

            String operationCode = parts[OPERATION_INDEX];
            String fruit = parts[FRUIT_INDEX];
            int quantity;

            try {
                quantity = Integer.parseInt(parts[QUANTITY_INDEX]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid quantity at line "
                        + (i + 1) + ": " + parts[QUANTITY_INDEX], e);
            }

            FruitTransaction.Operation operation =
                    FruitTransaction.Operation.fromCode(operationCode);
            transactions.add(new FruitTransaction(operation, fruit, quantity));
        }
        return transactions;
    }
}
