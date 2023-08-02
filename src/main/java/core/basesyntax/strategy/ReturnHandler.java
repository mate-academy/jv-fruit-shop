package core.basesyntax.strategy;

import core.basesyntax.service.implementation.StorageServiceImpl;

public class ReturnHandler implements StoreOperationsHandler {
    @Override
    public void applyOperation(String product, int quantity) {
        returnItem(product, quantity);
    }

    private void returnItem(String product, int quantity) {
        StorageServiceImpl storageService = new StorageServiceImpl();
        storageService.add(product, quantity);
    }

}
