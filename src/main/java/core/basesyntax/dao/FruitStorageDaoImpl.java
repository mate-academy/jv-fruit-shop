package core.basesyntax.dao;

import static core.basesyntax.db.FruitStorage.storage;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class FruitStorageDaoImpl implements FruitStorageDao {
    private final OperationStrategy operationStrategy;

    public FruitStorageDaoImpl(OperationStrategy operationStrategy) {
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
