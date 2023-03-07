package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CalculateService;
import core.basesyntax.strategy.OperationHandlerStrategy;
import java.util.List;

public class CalculateServiceImpl implements CalculateService {
    private OperationHandlerStrategy operationHandlerStrategy;

    public CalculateServiceImpl(OperationHandlerStrategy operationHandlerStrategy) {
        this.operationHandlerStrategy = operationHandlerStrategy;
    }

    @Override
    public void put(List<FruitTransaction> list) {
        for (FruitTransaction transaction : list) {
            operationHandlerStrategy.get(transaction);
        }
    }
}
