package core.basesyntax.strategy.handlers;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.strategy.OperationHandler;

public class SupplyHandler implements OperationHandler {
    private final StorageDao storage;

    public SupplyHandler(StorageDao storage) {
        this.storage = storage;
    }

    @Override
    public void handleOperation(String productType, int amount) {

    }
}
