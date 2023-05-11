package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.impl.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class BalanceImpl implements OperationHandler {
    private final FruitDao fruitDao;

    public BalanceImpl() {
        this.fruitDao = new FruitDaoImpl();
    }

    @Override
    public void operate(FruitTransaction transaction) {
        fruitDao.update(transaction.getFruit(), transaction.getQuantity());
    }
}
