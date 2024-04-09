package service.impl;

import model.FruitTransaction;
import model.Operation;
import service.TransactionMapper;

public class FruitTransactionMapper implements TransactionMapper {
    private static final int INDEX_OF_FRUIT = 1;
    private static final int INDEX_OF_OPERATION = 0;
    private static final int INDEX_OF_QUANTITY = 2;
    private static final String SEPARATOR = ",";

    @Override
    public FruitTransaction map(String dataLine) {
        String[] fruitTransaction = dataLine.split(SEPARATOR);
        Operation operation = Operation.parse(fruitTransaction[INDEX_OF_OPERATION]);
        String fruit = fruitTransaction[INDEX_OF_FRUIT];
        String quantity = fruitTransaction[INDEX_OF_QUANTITY];
        return new FruitTransaction(operation, fruit, quantity);
    }
}
