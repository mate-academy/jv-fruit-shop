package core.basesyntax.strategy.operation;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class SupplyHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public SupplyHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        fruitDao.update(transaction.getFruit(),
                fruitDao.getQuantity(transaction.getFruit()) + transaction.getQuantity());
    }
}
