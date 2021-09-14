package core.basesyntax.service.strategy;

import core.basesyntax.model.FruitRecord;
import core.basesyntax.service.amount.AmountHandler;
import java.util.Map;

public class AmountStrategyImpl implements AmountStrategy {
    private Map<FruitRecord.Type, AmountHandler> amountHandlers;

    public AmountStrategyImpl(Map<FruitRecord.Type, AmountHandler> amountHandlers) {
        this.amountHandlers = amountHandlers;
    }

    @Override
    public AmountHandler get(FruitRecord.Type operationType) {
        return amountHandlers.get(operationType);
    }
}
