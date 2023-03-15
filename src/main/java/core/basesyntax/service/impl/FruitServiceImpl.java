package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;

import java.util.ArrayList;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private static final int INDEX_OF_QUANTITY = 2;
    private static final int INDEX_OF_FRUIT = 1;
    private static final int INDEX_OF_OPERATION = 0;
    private static final String FIRST_COLUMN_NAME = "type";
    private static final String SECOND_COLUMN_NAME = "fruit";
    private static final String THIRD_COLUMN_NAME = "quantity";

    @Override
    public List<FruitTransaction> addNewFruit(List<String> convertedData) {
        List<FruitTransaction> fruitTransactionsList = new ArrayList<>();
        for (String s : convertedData) {
            String[] splittedString = s.split(",");
            if (!s.equals(FIRST_COLUMN_NAME) || !s.equals(SECOND_COLUMN_NAME) || !s.equals(THIRD_COLUMN_NAME)) {
                int quantity = Integer.parseInt(splittedString[INDEX_OF_QUANTITY]);
                String fruit = splittedString[INDEX_OF_FRUIT];
                String operation = splittedString[INDEX_OF_OPERATION];
                fruitTransactionsList.add(new FruitTransaction(quantity,
                        FruitTransaction.Operation.getOperation(operation), fruit));
            }
        }
        return fruitTransactionsList;
    }
}
