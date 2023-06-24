package core.basesyntax.strategy.operationhandler.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.impl.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.operationhandler.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    private final FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        fruitDao.saveFruit(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
