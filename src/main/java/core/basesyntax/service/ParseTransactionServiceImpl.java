package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;

public class ParseTransactionServiceImpl implements ParseTransactionService {
    private static final String SPLIT_SYMBOL = ",";
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int OPERATION_INDEX = 0;

    @Override
    public FruitTransaction parseTransaction(String line) {
        String[] fields = line.split(SPLIT_SYMBOL);
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(Operation.getByCode(fields[OPERATION_INDEX]));
        fruitTransaction.setFruit(fields[FRUIT_INDEX]);
        fruitTransaction.setQuantity(Integer.parseInt(fields[QUANTITY_INDEX]));
        return fruitTransaction;
    }
}
