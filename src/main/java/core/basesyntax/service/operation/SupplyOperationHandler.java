package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperationHandler implements FruitOperationHandler {
    private final FruitDao fruitDao;

    public SupplyOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int currentQuantity = fruitDao.getQuantity(fruit);
        int transactionQuantity = fruitTransaction.getQuantity();
        fruitDao.addFruit(fruit, currentQuantity + transactionQuantity);
    }
}
