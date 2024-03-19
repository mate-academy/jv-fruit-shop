package core.basesyntax.strategy.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.exception.NotEnoughProductAmountException;
import core.basesyntax.strategy.OperationStrategy;

public class PurchaseOperationStrategy implements OperationStrategy {
    private final StorageDao storageDao;

    public PurchaseOperationStrategy(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void process(String product, int quantity) {
        int currentQuantity = storageDao.getAmountByProductName(product);
        if (currentQuantity < quantity) {
            throw new NotEnoughProductAmountException(
                    String.format(
                            "No enough product %s amount: available - %d, needed - %d",
                            product,
                            currentQuantity,
                            quantity
                    )
            );
        }
        storageDao.putProduct(product, currentQuantity - quantity);
    }
}
