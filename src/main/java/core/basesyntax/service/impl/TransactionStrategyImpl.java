package core.basesyntax.service.impl;

import core.basesyntax.model.LineData;
import core.basesyntax.service.Parser;
import core.basesyntax.service.strategy.TransactionStrategy;
import java.util.Map;

public class TransactionStrategyImpl implements TransactionStrategy {
    private final Map<String, Parser.OperationHandler> operationMap;

    public TransactionStrategyImpl(Map<String, Parser.OperationHandler> operationMap) {
        this.operationMap = operationMap;
    }

    @Override
    public Parser.OperationHandler get(LineData lineData) {
        String operationType = lineData.getDailyAction();
        return operationMap.get(operationType.strip());
    }
}
