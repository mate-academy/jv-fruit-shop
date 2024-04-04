package core.basesyntax.strategy.handler;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public PurchaseOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void process(FruitTransaction fruitTransaction) {
        int fruitQuantityInStorage = fruitDao.get(fruitTransaction.getFruit());
        fruitDao.update(fruitTransaction.getFruit(),
                fruitQuantityInStorage - fruitTransaction.getQuantity());
    }
}
