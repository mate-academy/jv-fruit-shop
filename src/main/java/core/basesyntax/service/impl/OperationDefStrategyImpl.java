package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationDefStrategy;
import java.util.Map;

public class OperationDefStrategyImpl implements OperationDefStrategy {
    private Map<String, FruitTransaction.Operation> operationMap;

    public OperationDefStrategyImpl(Map<String, FruitTransaction.Operation> operationMap) {
        this.operationMap = operationMap;
    }

    @Override
    public FruitTransaction.Operation get(String code) {
        return operationMap.get(code);
    }
}
