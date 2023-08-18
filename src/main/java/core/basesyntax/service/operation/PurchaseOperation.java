package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperation implements OperationHandler {

    @Override
    public void processWithTransaction(FruitTransaction transaction) {
        int quantityOfFruit = Storage.getFruits().get(transaction.getFruit());
        if (quantityOfFruit < transaction.getQuantity()) {
            throw new RuntimeException("We don't have than much fruit to sell");
        }
        Storage.getFruits().put(transaction.getFruit(),
                quantityOfFruit - transaction.getQuantity());
    }
}
