package core.basesyntax.impl;

import static core.basesyntax.db.FruitStorage.storage;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.TransactionService;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    private final OperationStrategy operationStrategy;

    public TransactionServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void addToStorage(List<FruitTransaction> activities) {
        for (FruitTransaction activity : activities) {
            Fruit fruit = activity.getFruit();
            int inputQuantity = activity.getQuantity();
            if (!storage.containsKey(fruit)) {
                storage.put(fruit, inputQuantity);
            } else {
                int currentQuantity = storage.get(fruit);
                Operation activityType = activity.getOperation();
                int newQuantity = operationStrategy.get(activityType)
                        .apply(currentQuantity, inputQuantity);
                storage.replace(fruit, newQuantity);
            }
        }
    }
}
