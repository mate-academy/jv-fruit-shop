package core.basesyntax.impl;

import static core.basesyntax.db.FruitStorage.storage;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.TransactionService;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    private OperationStrategy operationStrategy;

    public TransactionServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void addToStorage(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            Fruit fruit = transaction.getFruit();
            int inputQuantity = transaction.getQuantity();
            if (!storage.containsKey(fruit)) {
                storage.put(fruit, inputQuantity);
            } else {
                int currentQuantity = storage.get(fruit);
                int newQuantity = operationStrategy.get(transaction.getOperation())
                        .doOperation(currentQuantity, inputQuantity);
                storage.replace(fruit, newQuantity);
            }
        }
    }
}
