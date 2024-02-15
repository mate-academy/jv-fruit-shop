package core.basesyntax.service.operation.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationStrategy;
import java.util.NoSuchElementException;
import java.util.Optional;

public class PurchaseOperationStrategy implements OperationStrategy {
    private final FruitDao fruitDao;

    public PurchaseOperationStrategy(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void performOperation(FruitTransaction fruitTransaction) {
        int fruitToPurchaseQuantity = fruitTransaction.getQuantity();
        Optional<Integer> fruitQuantityAvailable =
                fruitDao.getFruitQuantityByName(fruitTransaction.getFruitName());
        if (fruitQuantityAvailable.isEmpty()) {
            throw new NoSuchElementException("Can't find specified fruit available");
        }
        if (fruitToPurchaseQuantity > fruitQuantityAvailable.get()) {
            throw new IllegalArgumentException(
                    "Can't purchase more fruits than available in store");
        }
        fruitDao.subtractFruitQuantity(fruitTransaction.getFruitName(), fruitToPurchaseQuantity);
    }
}
