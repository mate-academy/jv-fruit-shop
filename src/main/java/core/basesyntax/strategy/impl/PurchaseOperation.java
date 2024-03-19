package core.basesyntax.strategy.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.StorageService;
import core.basesyntax.service.impl.StorageServiceImpl;
import core.basesyntax.strategy.Operation;

public class PurchaseOperation implements Operation {
    private final StorageService storageService;

    public PurchaseOperation() {
        storageService = new StorageServiceImpl();
    }

    @Override
    public void execute(Transaction transaction) {
        String name = transaction.getName();
        int purchaseQuantity = transaction.getQuantity();
        int quantity = storageService.get(name);

        if (quantity < purchaseQuantity) {
            throw new RuntimeException("Insufficient quantity in stock. Cannot purchase "
                    + purchaseQuantity + " items when only " + quantity + " items are available.");
        }

        storageService.update(name, quantity - purchaseQuantity);
    }
}
