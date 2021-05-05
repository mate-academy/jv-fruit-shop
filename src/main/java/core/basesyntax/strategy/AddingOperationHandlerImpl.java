package core.basesyntax.strategy;

import core.basesyntax.dto.Operation;
import core.basesyntax.service.StorageService;

public class AddingOperationHandlerImpl implements OperationHandler {
    private final StorageService storage;

    public AddingOperationHandlerImpl(StorageService storage) {
        this.storage = storage;
    }

    @Override
    public void handle(Operation operation) {
        int currentBalance = storage.read(operation.getFruit());
        int newBalance = currentBalance + operation.getQuantity();
        storage.update(operation.getFruit(), newBalance);
    }
}
