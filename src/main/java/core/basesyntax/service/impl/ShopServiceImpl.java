package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransactionImpl;
import core.basesyntax.operationhandlers.OperationHandler;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransactionImpl> transactions) {
        for (FruitTransactionImpl transaction : transactions) {
            OperationHandler handler = operationStrategy.getHandler(transaction.getOperation());
            if (handler == null) {
                throw new IllegalArgumentException("Unknown operation: "
                        + transaction.getOperation());
            }
            handler.apply(transaction);
        }
    }
}
