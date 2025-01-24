package core.basesyntax.services;

import core.basesyntax.ActivityStrategy;
import core.basesyntax.db.Storage;
import core.basesyntax.models.FruitTransaction;
import java.util.List;

public class DataProcessorImpl implements DataProcessor {
    private final ActivityStrategy activityStrategy;
    public DataProcessorImpl(ActivityStrategy activityStrategy) {
        this.activityStrategy = activityStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            Integer currentQuantity = Storage.FRUIT_TRANSACTION_STORAGE
                    .getOrDefault(transaction.getName(), 0);
            Integer newQuantity = activityStrategy
                    .getActivity(transaction.getType())
                    .apply(currentQuantity, transaction.getQuantity());
            Storage.FRUIT_TRANSACTION_STORAGE.put(transaction.getName(), newQuantity);
        }
    }

}
