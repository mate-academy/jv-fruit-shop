package core.basesyntax.strategy;

import core.basesyntax.service.StorageSupplyService;
import core.basesyntax.service.impl.StorageSupplyServiceImpl;

public class AdditionHandler implements OperationHandler {
    private StorageSupplyService storageSupplyService = new StorageSupplyServiceImpl();

    @Override
    public void execute(String fruit, Integer amount) {
        storageSupplyService.add(fruit, amount);
    }
}
