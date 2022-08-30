package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.AmountHandler;
import core.basesyntax.strategy.AmountStrategy;
import java.util.Map;

public class AmountStrategyImpl implements AmountStrategy {
    private final Map<String, AmountHandler> amountHandlerMap;

    public AmountStrategyImpl(Map<String, AmountHandler> amountHandlerMap) {
        this.amountHandlerMap = amountHandlerMap;
    }

    @Override
    public AmountHandler get(String operationCode) {
        return amountHandlerMap.get(operationCode);
    }
}
