package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final int INDEX_OPERATION = 0;
    private static final int INDEX_FRUIT = 1;
    private static final int INDEX_QUANTITY = 2;
    private static final String HEADER = "type,fruit,quantity";
    private static final String DELIMITER = ",";

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : inputReport) {
            if (line.equals(HEADER)) {
                continue;
            }
            String[] parts = line.split(DELIMITER);
            FruitTransaction.Operation operation = FruitTransaction.Operation
                    .fromCode(parts[INDEX_OPERATION]);
            String fruit = parts[INDEX_FRUIT];
            int quantity = Integer.parseInt(parts[INDEX_QUANTITY]);
            transactions.add(new FruitTransaction(operation, fruit, quantity));
        }
        return transactions;
    }
}
