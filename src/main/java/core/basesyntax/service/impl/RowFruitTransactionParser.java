package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionParser;

public class RowFruitTransactionParser implements FruitTransactionParser<String[]> {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    @Override
    public FruitTransaction parse(String[] value) {
        return new FruitTransaction(
                FruitTransaction.Operation.getByCode(value[OPERATION_INDEX]),
                value[FRUIT_INDEX],
                Integer.valueOf(value[QUANTITY_INDEX]));
    }
}
