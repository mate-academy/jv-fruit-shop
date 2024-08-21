package core.basesyntax.strategy;

import core.basesyntax.db.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    @Override
    public Integer executeOperation(FruitDao fruitDao, FruitTransaction fruitTransaction) {
        return fruitDao.putFruits(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
