package core.basesyntax.handlers.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.handlers.TransactionHandler;
import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class SaveTransactionHandler implements TransactionHandler {
    private final FruitStorage storage;

    public SaveTransactionHandler(FruitStorage storage) {
        this.storage = storage;
    }

    @Override
    public void process(FruitTransaction transaction) {
        Map<String, Integer> fruitMap = storage.getStorage();
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();
        int newQuantity = fruitMap.get(fruit) != null ? fruitMap.get(fruit) + quantity : quantity;
        fruitMap.put(fruit, newQuantity);
    }
}
