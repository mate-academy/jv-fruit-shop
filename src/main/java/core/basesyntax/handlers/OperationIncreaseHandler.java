package core.basesyntax.handlers;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.exeptions.InvalidAmountException;
import core.basesyntax.model.product.Fruit;
import java.util.Optional;

public class OperationIncreaseHandler implements OperationHandler {
    private final StorageDao storageDao;

    public OperationIncreaseHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public int apply(Fruit fruit, int amount) {
        Optional<Integer> amountFromStorage = storageDao.get(fruit).isEmpty()
                ? Optional.of(0) : storageDao.get(fruit);
        if (amount < 0) {
            throw new InvalidAmountException();
        }
        int newAmount = amountFromStorage.get() + amount;
        storageDao.add(fruit, newAmount);
        return newAmount;
    }
}
