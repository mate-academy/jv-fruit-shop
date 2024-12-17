package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandlerStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationHandlerStrategy operationHandlerStrategy;

    public ShopServiceImpl(OperationHandlerStrategy operationHandlerStrategy) {
        this.operationHandlerStrategy = operationHandlerStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            operationHandlerStrategy.getOperationHandler(transaction)
                    .executeOperation(transaction);
        }
    }
}
