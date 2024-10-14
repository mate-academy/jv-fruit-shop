package core.basesyntax.service.operation;

import core.basesyntax.service.FruitTransaction;
import core.basesyntax.service.db.StorageService;
import java.util.Map;

public class PurchaseOperationHandler implements OperationHandler {
    private final StorageService storageService;

    public PurchaseOperationHandler(StorageService storageService) {
        this.storageService = storageService;
    }

    @Override
    public void handle(FruitTransaction transaction, Map<String, Integer> storage) {
        String fruit = transaction.getFruit();
        int amount = transaction.getAmount();
        storageService.purchaseFruit(fruit, amount);
    }
}
