package core.basesyntax.strategy.handlers;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.strategy.OperationHandler;

public class ReturnHandler implements OperationHandler {
    private final StorageDao storage;

    public ReturnHandler(StorageDao storage) {
        this.storage = storage;
    }

    @Override
    public void handleOperation(String productType, int amount) {

    }
}
