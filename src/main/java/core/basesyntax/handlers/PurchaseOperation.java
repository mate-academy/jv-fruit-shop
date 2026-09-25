package core.basesyntax.handlers;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.fruittransaction.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    private final FruitsDao dao;

    public PurchaseOperation(FruitsDao dao) {
        this.dao = dao;
    }

    @Override
    public void updateData(FruitTransaction transaction) {
        Integer currentFruitQuantity = dao.getFruitFromStorage(transaction.getFruitName());

        if (currentFruitQuantity == null) {
            throw new RuntimeException("Can't find the fruit" + transaction.getFruitName());
        }

        int newQuantity = currentFruitQuantity - transaction.getQuantity();

        if (newQuantity < 0) {
            throw new RuntimeException("New value of "
                    + transaction.getFruitName()
                    + " can't be less than 0");
        }

        dao.addFruitToStorage(transaction.getFruitName(), newQuantity);
    }
}
