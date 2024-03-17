package core.basesyntax.strategy.handlers;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.strategy.OperationHandler;

public class BalanceHandler implements OperationHandler {
    private final StorageDao storage;

    public BalanceHandler(StorageDao storage) {
        this.storage = storage;
    }

    @Override
    public void handleOperation(String productType, int amount) {

    }
}
