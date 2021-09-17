package core.basesyntax.service.strategy;

import core.basesyntax.model.FruitRecord;
import core.basesyntax.service.amount.AmountHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitRecord.Type, AmountHandler> amountHandlers;

    public OperationStrategyImpl(Map<FruitRecord.Type, AmountHandler> amountHandlers) {
        this.amountHandlers = amountHandlers;
    }

    @Override
    public AmountHandler get(FruitRecord.Type operationType) {
        return amountHandlers.get(operationType);
    }
}
