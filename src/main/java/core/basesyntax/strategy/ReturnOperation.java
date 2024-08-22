package core.basesyntax.strategy;

import core.basesyntax.db.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperation implements OperationHandler {
    @Override
    public Integer executeOperation(FruitDao fruitDao, FruitTransaction fruitTransaction) {
        return fruitDao.updateFruitQuantity(fruitTransaction.getFruit(),
                fruitTransaction.getQuantity());
    }
}
