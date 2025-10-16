package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    private final FruitDao fruitDao;

    public PurchaseOperation(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        if (transaction == null) {
            throw new IllegalArgumentException(
                    "transaction must not be null");
        }
        if (transaction.getFruit() == null
                || transaction.getFruit().trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "transaction.fruit must not be null or blank");
        }
        fruitDao.remove(transaction.getFruit(), transaction.getQuantity());
    }
}
