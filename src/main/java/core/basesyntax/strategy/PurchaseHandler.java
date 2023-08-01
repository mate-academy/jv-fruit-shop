package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandlerService;

public class PurchaseHandler implements OperationHandlerService {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        String fruitName = fruitTransaction.getFruit();
        int purchaseQuantity = fruitTransaction.getQuantity();
        int storageQuantity = Storage.fruit.get(fruitName);
        if (storageQuantity - purchaseQuantity < 0) {
            throw new RuntimeException("Not enough fruit in storage");
        }
        Storage.fruit.put(fruitName,storageQuantity - purchaseQuantity);

    }
}
