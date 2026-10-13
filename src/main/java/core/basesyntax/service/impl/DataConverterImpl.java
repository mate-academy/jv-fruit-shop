package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int COLUMNS_COUNT = 3;
    private static final String SEPARATOR = ",";

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> lines) {
        List<FruitTransaction> transactions = new ArrayList<>();

        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i).trim();
            String[] parts = line.split(SEPARATOR);

            if (parts.length != COLUMNS_COUNT) {
                throw new RuntimeException("Invalid line format: " + line);
            }

            try {
                int quantity = Integer.parseInt(parts[QUANTITY_INDEX]);

                if (quantity < 0) {
                    throw new RuntimeException("Invalid quantity in line: " + line);
                }

                FruitTransaction transaction = new FruitTransaction(
                        FruitTransaction.Operation.fromCode(parts[OPERATION_INDEX]),
                        parts[FRUIT_INDEX],
                        quantity
                );
                transactions.add(transaction);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Invalid line format: " + line, e);
            }
        }

        return transactions;
    }
}
