package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandlerService;

public class ReturnHandler implements OperationHandlerService {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        String fruitName = fruitTransaction.getFruit();
        int quantity = fruitTransaction.getQuantity();
        if (Storage.fruitsStorage.containsKey(fruitName)) {
            int storageQuantity = Storage.fruitsStorage.get(fruitName);
            Storage.fruitsStorage.put(fruitName, quantity + storageQuantity);
        } else {
            Storage.fruitsStorage.put(fruitName, quantity);
        }
    }
}
