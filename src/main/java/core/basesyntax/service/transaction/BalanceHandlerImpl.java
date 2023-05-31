package core.basesyntax.service.transaction;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;

public class BalanceHandlerImpl implements TransactionHandler {
    private final FruitDao fruitDao;

    public BalanceHandlerImpl() {
        fruitDao = new FruitDaoImpl();
    }

    @Override
    public void handleTransaction(FruitTransaction transaction) {
        fruitDao.add(transaction.getFruit(), transaction.getQuantity());
    }
}
