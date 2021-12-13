package core.basesyntax.handlers;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.exeptions.InvalidAmountException;
import core.basesyntax.model.product.Fruit;

public class OperationDecreaseHandler implements OperationHandler {
    private final StorageDao storageDao;

    public OperationDecreaseHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public int apply(Fruit fruit, int amount) {
        int amountFromStorage = storageDao.get(fruit).orElse(0);
        if (amountFromStorage < amount) {
            throw new InvalidAmountException();
        }
        int newAmount = amountFromStorage - amount;
        storageDao.add(fruit, newAmount);
        return newAmount;
    }
}
