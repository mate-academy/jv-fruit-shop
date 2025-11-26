package core.basesyntax.strategy.operation;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    private FruitsDao fruitsDao;

    public PurchaseOperation(FruitsDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public void transaction(FruitTransaction fruitTransaction) {
        Integer i = fruitsDao.get(fruitTransaction.getName());

        int quantity = i - fruitTransaction.getQuantity();

        if (quantity < 0) {
            throw new RuntimeException("Quantity negative value");
        }

        fruitsDao.set(fruitTransaction.getName(), quantity);
    }
}
