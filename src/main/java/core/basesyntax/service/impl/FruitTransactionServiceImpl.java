package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionService;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int FRUIT_AMOUNT_INDEX = 2;

    @Override
    public FruitTransaction createNewFruitTransaction(String FruitTransactionString) {
        String[] fields = FruitTransactionString.split(SEPARATOR);
        return FruitTransaction.of(fields[FRUIT_NAME_INDEX],
                Integer.parseInt(fields[OPERATION_INDEX]),
                FruitTransaction.Operation.valueOf((fields[FRUIT_AMOUNT_INDEX])));
    }
}
