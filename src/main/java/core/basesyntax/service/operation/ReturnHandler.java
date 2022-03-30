package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.exception.OperationException;

public class ReturnHandler implements OperationHandler {
    private final FruitStorageDao fruitStorageDao;

    public ReturnHandler(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public void apply(String fruitName, int quantity) {
        if (!fruitStorageDao.containsKey(fruitName)) {
            throw new OperationException("Unavailable fruit cannot be returned");
        }
        fruitStorageDao.update(fruitName, quantity);
    }
}
