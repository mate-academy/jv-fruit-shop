package core.basesyntax.utils.impl;

import core.basesyntax.db.StorageOfData;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.utils.CalculateOperation;

public class ReturnOperation implements CalculateOperation {

    @Override
    public void count(FruitTransaction transaction) {
        StorageOfData.fruitsData.compute(transaction.getFruit(),
                (key, value) -> value == null ? 1 : value + transaction.getQuantity());
    }
}
