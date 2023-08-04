package core.basesyntax.strategy;

import core.basesyntax.service.StorageService;
import core.basesyntax.service.implementation.StorageServiceImpl;

public class SupplyHandler implements FruitShopOperationsHandler {
    private StorageService storageService;

    public SupplyHandler() {
        storageService = new StorageServiceImpl();
    }

    @Override
    public void applyOperation(String product, int quantity) {
        storageService.add(product, quantity);
    }
}
