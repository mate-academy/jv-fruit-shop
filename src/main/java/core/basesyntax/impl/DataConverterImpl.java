package core.basesyntax.impl;

import core.basesyntax.FruitTransaction;
import core.basesyntax.dao.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String COMMA = ",";
    private static final int START_INDEX = 1;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> data) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : data.subList(START_INDEX, data.size())) {
            String[] parts = line.split(COMMA);
            FruitTransaction.Operation operation =
                    FruitTransaction.Operation.fromCode(parts[OPERATION_INDEX].trim());
            String fruit = parts[FRUIT_INDEX].trim();
            int quantity = Integer.parseInt(parts[QUANTITY_INDEX].trim());
            transactions.add(new FruitTransaction(operation, fruit, quantity));
        }
        return transactions;
    }
}
