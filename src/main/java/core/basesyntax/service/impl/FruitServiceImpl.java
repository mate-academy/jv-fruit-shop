package core.basesyntax.service.impl;

import core.basesyntax.model.OperationType;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.OperationsHandler;
import java.util.HashMap;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private Map<OperationType, OperationsHandler> operationStrategies = new HashMap<>();

    public FruitServiceImpl(Map<OperationType, OperationsHandler> operationStrategies) {
        this.operationStrategies = operationStrategies;
    }

    @Override
    public OperationsHandler getOperationStrategies(String operationsCode) {
        return operationStrategies.entrySet()
                .stream()
                .filter(s -> s.getKey().getCode().equals(operationsCode))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Incorrect operation"));
    }
}
