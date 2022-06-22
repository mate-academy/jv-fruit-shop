package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataService;
import java.util.ArrayList;
import java.util.List;

public class DataServiceImpl implements DataService {
    private static final int FIRST_INDEX = 0;
    private static final int INDEX_OF_FRUIT = 1;
    private static final int INDEX_OF_QUANTITY = 2;

    @Override
    public List<FruitTransaction> processData(List<String> activities) {
        activities.remove(FIRST_INDEX);
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (String activity : activities) {
            String[] strings = activity.split(",");
            FruitTransaction.Operation operation = FruitTransaction
                    .getOperationName(strings[FIRST_INDEX]);
            String fruit = strings[INDEX_OF_FRUIT];
            int quantity = Integer.parseInt(strings[INDEX_OF_QUANTITY]);
            FruitTransaction fruitTransaction = new FruitTransaction(operation, fruit, quantity);
            fruitTransactions.add(fruitTransaction);
        }
        return fruitTransactions;
    }
}
