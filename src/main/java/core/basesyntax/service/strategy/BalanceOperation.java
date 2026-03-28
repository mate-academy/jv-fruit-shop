package core.basesyntax.service.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Storage;
import core.basesyntax.service.OperationHandler;
import java.util.Map;

public class BalanceOperation implements OperationHandler {

    private Storage storage;

    public BalanceOperation(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Map<String, Integer> currentBalance = storage.getStorage();
        String fruit = fruitTransaction.getFruit();
        int quantity = fruitTransaction.getQuantity();
        currentBalance.put(fruit, quantity);

    }
}
