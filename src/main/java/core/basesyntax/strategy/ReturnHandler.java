package core.basesyntax.strategy;

import core.basesyntax.service.implementation.StorageServiceImpl;

public class ReturnHandler implements FruitShopOperationsHandler {
    @Override
    public void applyOperation(String product, int quantity) {
        StorageServiceImpl storageService = new StorageServiceImpl();
        storageService.add(product, quantity);
    }
}
