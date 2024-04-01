package core.basesyntax.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public ReturnOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void apply(FruitTransaction fruitTransaction) {
        fruitDao.update(fruitTransaction.getFruit(),
                fruitDao.get(fruitTransaction.getFruit()) + fruitTransaction.getQuantity());
    }
}
