package core.basesyntax.impl;

import core.basesyntax.database.Operation;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionService;
import java.util.ArrayList;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    private static final String SEPARATOR = ",";
    private static final int INDEX_OF_FRUIT_NAME = 1;
    private static final int INDEX_OF_OPERATION = 0;
    private static final int INDEX_OF_QUANTITY = 2;

    @Override
    public List<FruitTransaction> parseData(List<String> data) {
        List<FruitTransaction> list = new ArrayList<>();
        for (String fruits : data) {
            String[] parts = fruits.split(SEPARATOR);
            String name = parts[INDEX_OF_FRUIT_NAME];
            int quantity = Integer.parseInt(parts[INDEX_OF_QUANTITY]);
            Operation operation = Operation.getByCode(parts[INDEX_OF_OPERATION]);
            list.add(new FruitTransaction(operation, name, quantity));
        }
        return list;
    }
}
