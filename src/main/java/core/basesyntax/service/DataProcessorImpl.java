package core.basesyntax.service;

import core.basesyntax.model.FruitRecord;
import core.basesyntax.service.amount.AmountHandler;
import core.basesyntax.service.strategy.OperationStrategy;
import java.util.List;

public class DataProcessorImpl implements DataProcessor {
    private OperationStrategy operationStrategy;

    public DataProcessorImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public boolean processData(List<FruitRecord> records) {
        for (FruitRecord record : records) {
            AmountHandler amountHandler = operationStrategy.get(record.getType());
            if (!amountHandler.apply(record)) {
                return false;
            }
        }
        return true;
    }
}
