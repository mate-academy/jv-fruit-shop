package core.basesyntax.strategy;

import core.basesyntax.service.StorageService;
import core.basesyntax.service.impl.StorageServiceImpl;

public class AdditionHandler implements OperationHandler {
    private StorageService storageService = new StorageServiceImpl();

    @Override
    public void execute(String fruit, Integer amount) {
        storageService.add(fruit, amount);
    }
}
