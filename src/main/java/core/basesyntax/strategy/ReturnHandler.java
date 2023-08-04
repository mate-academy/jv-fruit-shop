package core.basesyntax.strategy;

import core.basesyntax.service.StorageService;
import core.basesyntax.service.implementation.StorageServiceImpl;

public class ReturnHandler implements FruitShopOperationsHandler {
    private StorageService storageService;

    public ReturnHandler() {
        storageService = new StorageServiceImpl();
    }

    @Override
    public void applyOperation(String product, int quantity) {
        storageService.add(product, quantity);
    }
}
