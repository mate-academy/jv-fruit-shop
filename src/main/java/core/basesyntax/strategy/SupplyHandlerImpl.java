package core.basesyntax.strategy;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.storage.Storage;

public class SupplyHandlerImpl implements OperationHandler {
    private final StorageDao dao;

    public SupplyHandlerImpl(StorageDao dao) {
        this.dao = dao;
    }

    @Override
    public void apply(Fruit fruit, int quantity) {
        if (!Storage.storage.containsKey(fruit)) {
            dao.add(fruit, quantity);
        } else {
            dao.supply(fruit, quantity);
        }
    }
}
