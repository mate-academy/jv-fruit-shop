package core.basesyntax.impl;

import static core.basesyntax.db.FruitStorage.storage;

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
            if (storage.containsKey(activity.getFruit())) {
                replaceValue(activity);
            } else {
                storage.put(activity.getFruit(), activity.getQuantity());
            }
        }
    }

    private void replaceValue(FruitTransaction activity) {
        Operation activityType = activity.getOperation();
        int currentQuantity = storage.get(activity.getFruit());
        int newQuantity = operationStrategy.get(activityType)
                .apply(currentQuantity, activity.getQuantity());
        storage.replace(activity.getFruit(), newQuantity);
    }
}
