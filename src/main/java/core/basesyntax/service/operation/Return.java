package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.db.Storage;
import core.basesyntax.exception.OperationException;

public class Return implements OperationHandler {
    private final FruitStorageDao fruitStorageDao;

    public Return(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public void apply(String fruitName, int quantity) {
        if (!Storage.fruitStorage.containsKey(fruitName)) {
            throw new OperationException("Unavailable fruit cannot be returned");
        }
        fruitStorageDao.update(fruitName, quantity);
    }
}
