package core.basesyntax.handlers;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.fruittransaction.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    private FruitsDao dao;

    @Override
    public void setDao(FruitsDao dao) {
        this.dao = dao;
    }

    @Override
    public void updateData(FruitTransaction transaction) {
        dao.addFruitToStorage(transaction.getFruitName(), transaction.getQuantity());
    }
}
