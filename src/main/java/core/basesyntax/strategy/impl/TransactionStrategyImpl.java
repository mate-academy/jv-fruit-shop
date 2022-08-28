package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.AmountHandler;
import core.basesyntax.strategy.TransactionStrategy;
import java.util.Map;

public class TransactionStrategyImpl implements TransactionStrategy {
    private final Map<String, AmountHandler> amountHandlerMap;

    public TransactionStrategyImpl(Map<String, AmountHandler> amountHandlerMap) {
        this.amountHandlerMap = amountHandlerMap;
    }

    @Override
    public AmountHandler get(String operationCode) {
        return amountHandlerMap.get(operationCode);
    }
}
