package core.basesyntax.service.operation;

import core.basesyntax.service.FruitTransaction;
import core.basesyntax.service.db.StorageService;
import java.util.Map;

public class BalanceOperationHandler implements OperationHandler {
    private final StorageService storageService;

    public BalanceOperationHandler(StorageService storageService) {
        this.storageService = storageService;
    }

    @Override
    public void handle(FruitTransaction transaction, Map<String, Integer> storage) {
        String fruit = transaction.getFruit();
        int amount = transaction.getAmount();
        storageService.updateBalance(fruit, amount);
    }
}
