package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.FruitTransactionHandler;

public class BalanceHandler implements FruitTransactionHandler {
    private final FruitDao fruitDao;

    public BalanceHandler() {
        this.fruitDao = new FruitDaoImpl();
    }

    @Override
    public void handleTransaction(FruitTransaction fruitTransaction) {
        fruitDao.saveQuantity(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
