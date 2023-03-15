package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;

import java.util.ArrayList;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private static final int INDEX_OF_QUANTITY = 2;
    private static final int INDEX_OF_FRUIT = 1;
    private static final int INDEX_OF_OPERATION = 0;

    @Override
    public List<FruitTransaction> addNewFruit(List<String[]> convertedData) {
        List<FruitTransaction> fruitTransactionsList = new ArrayList<>();
        for (String[] s : convertedData) {
            int quantity = Integer.parseInt(s[INDEX_OF_QUANTITY]);
            String fruit = s[INDEX_OF_FRUIT];
            String operation = s[INDEX_OF_OPERATION];
            fruitTransactionsList.add(new FruitTransaction(quantity,
                    FruitTransaction.Operation.getOperation(operation), fruit));
        }
        return fruitTransactionsList;
    }
}
