package core.basesyntax.handlers.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.handlers.TransactionHandler;
import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class RemoveTransactionHandler implements TransactionHandler {
    private static final String NOT_ENOUGH_FRUITS = "Not enough fruits in the storage";
    private static final String NO_SUCH_FRUIT = "No such fruit in the storage";
    private final FruitStorage storage;

    public RemoveTransactionHandler(FruitStorage storage) {
        this.storage = storage;
    }

    @Override
    public void process(FruitTransaction transaction) {
        Map<String, Integer> fruitMap = storage.getStorage();
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();
        if (fruitMap.get(fruit) != null) {
            if (fruitMap.get(fruit) >= quantity) {
                fruitMap.put(fruit, fruitMap.get(fruit) - quantity);
            } else {
                throw new RuntimeException(NOT_ENOUGH_FRUITS);
            }
        } else {
            throw new RuntimeException(NO_SUCH_FRUIT);
        }
    }
}
