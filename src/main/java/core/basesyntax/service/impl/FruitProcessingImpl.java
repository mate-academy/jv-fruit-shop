package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitProcessing;
import core.basesyntax.service.TransactionHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitProcessingImpl implements FruitProcessing {
    @Override
    public Map<String, Integer> fruitProcessing(List<FruitTransaction> fruitTransactions) {
        TransactionHandler transactionHandler = new TransactionHandler();
        Map<String, Integer> fruits = new HashMap<>();
        for (FruitTransaction fruit : fruitTransactions) {
            fruits.put(fruit.getFruitName(), transactionHandler
                    .getStrategy(fruit.getOperation())
                    .balanceUpdater(fruit.getFruitName(), fruit.getQuantity()));
        }
        return fruits;
    }
}


