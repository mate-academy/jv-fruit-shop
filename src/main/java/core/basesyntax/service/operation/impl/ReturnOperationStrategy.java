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
        Optional<Integer> fruitQuantityInStore = fruitDao.getFruitQuantityByName(fruitName);
        if (fruitQuantityInStore.isEmpty()) {
            fruitDao.addFruitQuantity(fruitName, fruitQuantity);
            return;
        }
        int afterReturnQuantity = fruitQuantityInStore.get() + fruitQuantity;
        fruitDao.addFruitQuantity(fruitName, afterReturnQuantity);
    }
}
