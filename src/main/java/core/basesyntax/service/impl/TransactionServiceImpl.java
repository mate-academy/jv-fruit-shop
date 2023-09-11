package core.basesyntax.service.impl;

import core.basesyntax.exception.InvalidDataException;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.TransactionService;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    private static final String SPLIT_DELIMITER = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parseTransactions(List<String> lines) {
        return lines.stream()
                .map(this::getFruitTransaction)
                .toList();
    }

    private FruitTransaction getFruitTransaction(String record) {
        String[] transaction = record.split(SPLIT_DELIMITER);
        Operation operation = Operation.getByCode(transaction[OPERATION_INDEX]);
        int quantity = Integer.parseInt(transaction[QUANTITY_INDEX]);
        if (quantity < 0) {
            throw new InvalidDataException("Quantity can't be negative value: " + record);
        }
        return new FruitTransaction(operation, transaction[FRUIT_NAME_INDEX], quantity);
    }
}
