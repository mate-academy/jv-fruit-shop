package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandlerStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private OperationHandlerStrategy operationHandlerStrategy;

    public ShopServiceImpl(OperationHandlerStrategy operationHandlerStrategy) {
        this.operationHandlerStrategy = operationHandlerStrategy;
    }

    public OperationHandlerStrategy getOperationHandlerStrategy() {
        return operationHandlerStrategy;
    }

    @Override
    public Boolean process(List<FruitTransaction> transactions) {
        for (FruitTransaction t : transactions) {
            operationHandlerStrategy.getOperationHandler(t).executeOperation(t);
        }
        return true;
    }
}
