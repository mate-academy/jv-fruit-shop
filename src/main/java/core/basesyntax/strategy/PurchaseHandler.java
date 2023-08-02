package core.basesyntax.strategy;

import core.basesyntax.service.implementation.StorageServiceImpl;

public class PurchaseHandler implements FruitShopOperationsHandler {
    @Override
    public void applyOperation(String product, int quantity) {
        purchase(product, quantity);
    }

    private void purchase(String product, int quantity) {
        StorageServiceImpl storageService = new StorageServiceImpl();
        storageService.remove(product, quantity);
    }
}
