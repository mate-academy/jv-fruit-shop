package core.basesyntax.strategy;

import core.basesyntax.service.StorageService;

public class BalanceHandler implements FruitShopOperationsHandler {
    private StorageService storageService;

    public BalanceHandler(StorageService storageService) {
        this.storageService = storageService;
    }

    @Override
    public void applyOperation(String product, int quantity) {
        storageService.add(product, quantity);
    }
}
