package core.basesyntax.handlers;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.fruittransaction.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    private FruitsDao dao;

    @Override
    public void setDao(FruitsDao dao) {
        this.dao = dao;
    }

    @Override
    public void updateData(FruitTransaction transaction) {
        Integer currentFruitQuantity = dao.getFruitFromStorage(transaction.getFruitName());
        dao.addFruitToStorage(transaction.getFruitName(), currentFruitQuantity
                - transaction.getQuantity());
    }
}
