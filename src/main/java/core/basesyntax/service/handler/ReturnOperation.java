package core.basesyntax.service.handler;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.Storage;
import java.util.Map;

public class ReturnOperation implements OperationHandler {
    @Override
    public void transaction(FruitTransaction fruitTransaction, Storage storage) {
        Map<String, Integer> fruits = storage.getFruits();
        fruits.replace(fruitTransaction.getFruitName(),
                (fruits.get(fruitTransaction.getFruitName())
                        + (fruitTransaction.getTransactionQuantity())));
    }
}
