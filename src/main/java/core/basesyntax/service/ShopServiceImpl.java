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
        for (FruitTransaction transaction : transactions) {
            operationHandlerStrategy.getOperationHandler(transaction)
                    .executeOperation(transaction);
        }
        return true;
    }
}
