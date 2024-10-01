package core.basesyntax.strategy;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.StorageService;

public class DecrementHandler implements OperationHandler {
    private final StorageService storageService;

    public DecrementHandler(StorageService storageService) {
        this.storageService = storageService;
    }

    @Override
    public void handle(Fruit fruit, int quantity) {
        storageService.removeFruit(fruit, quantity);
    }
}

