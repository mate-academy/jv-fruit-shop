package core.basesyntax.service.operation.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationStrategy;
import java.util.Optional;

public class ReturnOperationStrategy implements OperationStrategy {
    private final FruitDao fruitDao;

    public ReturnOperationStrategy(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void performOperation(FruitTransaction fruitTransaction) {
        String fruitName = fruitTransaction.getFruitName();
        Integer fruitQuantity = fruitTransaction.getQuantity();
        fruitDao.addFruitQuantity(fruitName, fruitQuantity);
    }
}
