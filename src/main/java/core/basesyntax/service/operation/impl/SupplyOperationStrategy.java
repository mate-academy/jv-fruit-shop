package core.basesyntax.service.operation.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationStrategy;

public class SupplyOperationStrategy implements OperationStrategy {
    private final FruitDao fruitDao;

    public SupplyOperationStrategy(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void performOperation(FruitTransaction fruitTransaction) {
        String fruitName = fruitTransaction.getFruitName();
        Integer fruitQuantity = fruitTransaction.getQuantity();
        fruitDao.addFruitQuantity(fruitName, fruitQuantity);
    }
}
