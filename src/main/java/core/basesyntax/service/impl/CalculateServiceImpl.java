package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CalculateService;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationHandlerStrategy;
import java.util.List;

public class CalculateServiceImpl implements CalculateService {
    private OperationHandlerStrategy operationHandlerStrategy;

    public CalculateServiceImpl(OperationHandlerStrategy operationHandlerStrategy) {
        this.operationHandlerStrategy = operationHandlerStrategy;
    }

    @Override
    public void process(List<FruitTransaction> list) {
        for (FruitTransaction transaction : list) {
            OperationHandler handler = operationHandlerStrategy.get(transaction);
            handler.handle(transaction);
        }
    }
}
