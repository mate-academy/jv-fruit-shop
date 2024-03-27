package core.basesyntax.service.operations.strategy;

import core.basesyntax.dao.FruitTransactionDao;

public class SupplyOperationHandler implements OperationHandler {

    private final FruitTransactionDao fruitTransactionDao;

    public SupplyOperationHandler(FruitTransactionDao fruitTransactionDao) {
        this.fruitTransactionDao = fruitTransactionDao;
    }

    @Override
    public void performOperation(String name, int quantity) {
        fruitTransactionDao.update(name, fruitTransactionDao.getByName(name) + quantity);
    }
}
