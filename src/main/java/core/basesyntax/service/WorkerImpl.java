package core.basesyntax.service;

import core.basesyntax.model.FruitRecord;
import core.basesyntax.service.amount.AmountHandler;
import core.basesyntax.service.strategy.AmountStrategy;
import java.util.List;

public class WorkerImpl implements Worker {
    private AmountStrategy amountStrategy;

    public WorkerImpl(AmountStrategy amountStrategy) {
        this.amountStrategy = amountStrategy;
    }

    @Override
    public void processData(List<FruitRecord> records) {
        for (FruitRecord record : records) {
            AmountHandler amountHandler = amountStrategy.get(record.getType());
            amountHandler.modifyAmount(record);
        }
    }
}
