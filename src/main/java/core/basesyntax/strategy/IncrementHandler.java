package core.basesyntax.strategy;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.StorageService;

public class IncrementHandler implements OperationHandler {
    private final StorageService storageService;

    public IncrementHandler(StorageService storageService) {
        this.storageService = storageService;
    }

    @Override
    public void handle(String fruitName, int quantity) {
        Fruit fruit = new Fruit(fruitName);
        storageService.increment(fruit, quantity);
    }
}
