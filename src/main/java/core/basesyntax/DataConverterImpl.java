package core.basesyntax;

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
            FruitTransaction.Operation operation
                    = FruitTransaction.Operation.valueOf(parts[OPERATION_INDEX].toUpperCase());
            String fruit = parts[FRUIT_INDEX];
            int quantity = Integer.parseInt(parts[QUANTITY_INDEX]);
            transactions.add(new FruitTransaction(operation, fruit, quantity));
        }
        return transactions;
    }
}
