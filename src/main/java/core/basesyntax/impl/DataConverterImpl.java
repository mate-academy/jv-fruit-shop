package core.basesyntax.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String DELIMITER = ",";
    private static final int CORRECT_NUMBERS_OF_PARTS = 3;
    private static final int OPERATION = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> data) {
        List<FruitTransaction> transactions = new ArrayList<>();

        List<String> dataWithoutHeader = data.subList(1, data.size());

        for (String line : dataWithoutHeader) {
            String[] parts = line.split(DELIMITER);
            if (parts.length != CORRECT_NUMBERS_OF_PARTS) {
                continue;
            }
            FruitTransaction.Operation operation
                    = FruitTransaction.Operation.fromCode(parts[OPERATION]);
            String fruit = parts[FRUIT];
            int quantity = Integer.parseInt(parts[QUANTITY]);

            transactions.add(new FruitTransaction(operation, fruit, quantity));
        }

        return transactions;
    }
}
