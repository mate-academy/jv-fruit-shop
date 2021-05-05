package core.basesyntax.strategy;

import core.basesyntax.dto.Operation;
import core.basesyntax.exceptions.AlreadyHaveItException;
import core.basesyntax.service.StorageService;

public class BalanceOperationHandlerImpl implements OperationHandler {
    private final StorageService storage;

    public BalanceOperationHandlerImpl(StorageService storage) {
        this.storage = storage;
    }

    @Override
    public void handle(Operation operation) throws AlreadyHaveItException {
        storage.create(operation.getFruit(), operation);
    }
}
