package core.basesyntax.strategy.operation.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.Strategy;
import core.basesyntax.strategy.StrategyImpl;
import core.basesyntax.strategy.operation.Operation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitService {
    public void processTransaction(List<Transaction> transactions) {
        Map<Transaction.Operation, Operation> map = new HashMap<>();
        map.put(Transaction.Operation.BALANCE, new Balance());
        map.put(Transaction.Operation.SUPPLY, new Supply());
        map.put(Transaction.Operation.RETURN, new Return());
        map.put(Transaction.Operation.PURCHASE, new Purchase());
        Strategy operationStrategy = new StrategyImpl(map);
        for (Transaction transaction : transactions) {
            Operation handler = operationStrategy.getByOperation(transaction.getOperation());
            handler.apply(transaction);
        }
    }

    public void processIncomingTransaction(Transaction transaction) {
        Fruit fruit = transaction.getFruit();
        if (!Storage.storage.containsKey(fruit)) {
            Storage.storage.put(fruit, transaction.getSum());
        } else {
            Integer currentQuantity = Storage.storage.get(fruit) + transaction.getSum();
            Storage.storage.put(fruit, currentQuantity);
        }
    }

    public void processExpenseTransaction(Transaction transaction) {
        Fruit fruit = transaction.getFruit();
        if (!Storage.storage.containsKey(fruit)) {
            throw new RuntimeException(fruit + " is out of stock");
        } else {
            Integer currentQuantity = Storage.storage.get(fruit) - transaction.getSum();
            Storage.storage.put(fruit, currentQuantity);
        }
    }
}
