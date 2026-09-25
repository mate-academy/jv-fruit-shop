package core.basesyntax.handlers;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.fruittransaction.FruitTransaction;

public class SupplyOperation implements OperationHandler {
    private final FruitsDao dao;

    public SupplyOperation(FruitsDao dao) {
        this.dao = dao;
    }

    @Override
    public void updateData(FruitTransaction transaction) {
        Integer currentFruitQuantity = dao.getFruitFromStorage(transaction.getFruitName());

        int newQuantity = currentFruitQuantity != null
                ? currentFruitQuantity + transaction.getQuantity()
                : transaction.getQuantity();

        dao.addFruitToStorage(transaction.getFruitName(), newQuantity);
    }
}
