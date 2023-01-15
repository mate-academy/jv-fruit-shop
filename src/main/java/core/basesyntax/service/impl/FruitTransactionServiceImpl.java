package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.FruitTransaction.Operation;
import core.basesyntax.service.FruitTransactionService;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private static final int NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int OPERATION_INDEX = 0;

    @Override
    public FruitTransaction newFruitTransaction(String line) {
        String[] dividedLine = line.split(",");
        FruitTransaction fruitTransaction = new FruitTransaction(dividedLine[NAME_INDEX].strip(), 
                Integer.parseInt(dividedLine[QUANTITY_INDEX].strip()), 
                Operation.valueOfLabel(dividedLine[OPERATION_INDEX].strip()));
        return fruitTransaction;
    }
}
