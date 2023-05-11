package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.impl.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class ReturnImpl implements OperationHandler {
    private final FruitDao fruitDao;

    public ReturnImpl() {
        this.fruitDao = new FruitDaoImpl();
    }

    @Override
    public void operate(FruitTransaction transaction) {
        fruitDao.add(transaction.getFruit(), transaction.getQuantity());
    }
}
