package core.basesyntax.strategy;

import core.basesyntax.service.implementation.StorageServiceImpl;

public class BalanceHandler implements FruitShopOperationsHandler {
    @Override
    public void applyOperation(String product, int quantity) {
        balance(product, quantity);
    }

    private void balance(String product, int quantity) {
        StorageServiceImpl storageService = new StorageServiceImpl();
        storageService.add(product, quantity);
    }
}
