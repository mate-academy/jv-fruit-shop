package core.basesyntax.service.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Storage;
import core.basesyntax.service.OperationHandler;
import java.util.Map;

public class ReturnOperation implements OperationHandler {

    private Storage storage;

    public ReturnOperation(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Map<String, Integer> balance = storage.getStorage();
        String fruit = fruitTransaction.getFruit();
        int quantity = fruitTransaction.getQuantity();
        balance.put(fruit, balance.get(fruit) + quantity);
    }
}
