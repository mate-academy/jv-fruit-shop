package core.basesyntax.servise;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String COMMA = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int REQUIRED_PARTS_LENGTH = 3;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> content) {
        List<FruitTransaction> transactions = new ArrayList<>();

        for (String line : content) {
            String[] parts = line.split(COMMA);

            if (parts.length != REQUIRED_PARTS_LENGTH) {
                throw new IllegalArgumentException("Invalid input format: " + line);
            }

            String operationType = parts[OPERATION_INDEX];
            String fruit = parts[FRUIT_INDEX];
            int quantity = Integer.parseInt(parts[QUANTITY_INDEX]);

            Operation operation = Operation.getByCode(operationType);

            FruitTransaction transaction = new FruitTransaction(operation, fruit, quantity);
            transactions.add(transaction);
        }

        return transactions;
    }
}
