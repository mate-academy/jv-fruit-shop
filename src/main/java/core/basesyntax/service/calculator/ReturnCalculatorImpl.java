package core.basesyntax.service.calculator;

import core.basesyntax.db.StorageDao;
import core.basesyntax.service.operation.FruitOperation;

public class ReturnCalculatorImpl implements OperationCalculator {
    @Override
    public void handle(FruitOperation fruitTransaction) {
        StorageDao.FRUIT_KINDS_AND_QUANTITY.put(fruitTransaction.getFruit(),
                StorageDao.FRUIT_KINDS_AND_QUANTITY.get(fruitTransaction.getFruit())
                        + fruitTransaction.getQuantity());
    }
}
