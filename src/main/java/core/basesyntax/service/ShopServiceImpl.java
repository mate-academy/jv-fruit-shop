package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operations.OperationHandler;
import core.basesyntax.service.strategy.OperationStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler handler = operationStrategy
                    .getOperationHandler(transaction.getOperation());
            handler.apply(transaction);
        }
    }
}
