package core.basesyntax.strategy;

import core.basesyntax.service.StorageSupplyService;
import core.basesyntax.service.impl.StorageSupplyServiceImpl;

public class SubtractionHandler implements OperationHandler {
    private StorageSupplyService storageSupplyService = new StorageSupplyServiceImpl();

    @Override
    public void execute(String fruit, Integer amount) {
        storageSupplyService.subtract(fruit, amount);
    }
}
