package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandlerService;

public class SupplyHandler implements OperationHandlerService {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        String fruitName = fruitTransaction.getFruit();
        int quantity = fruitTransaction.getQuantity();
        if (Storage.fruit.containsKey(fruitName)) {
            int storageQuantity = Storage.fruit.get(fruitName);
            Storage.fruit.put(fruitName, quantity + storageQuantity);
        } else {
            Storage.fruit.put(fruitName, quantity);
        }
    }
}
