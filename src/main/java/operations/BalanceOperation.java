package operations;

import core.basesyntax.FruitTransaction;
import dao.DaoFruit;

public class BalanceOperation implements OperationHandler {
    private final DaoFruit fruitDao;

    public BalanceOperation(DaoFruit fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        fruitDao.addFruits(fruitTransaction.getFruit(), fruitTransaction.getAmount());
    }
}
