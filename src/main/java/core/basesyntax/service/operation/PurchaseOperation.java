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
        fruitDao.remove(transaction.getFruit(), transaction.getQuantity());
    }
}
