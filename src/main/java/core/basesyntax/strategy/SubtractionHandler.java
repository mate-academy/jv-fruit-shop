package core.basesyntax.strategy;

import core.basesyntax.service.StorageService;
import core.basesyntax.service.impl.StorageServiceImpl;

public class SubtractionHandler implements OperationHandler {
    private StorageService storageService = new StorageServiceImpl();

    @Override
    public void execute(String fruit, Integer amount) {
        storageService.subtract(fruit, amount);
    }
}
