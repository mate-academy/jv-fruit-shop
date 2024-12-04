package core.basesyntax.service;

import core.basesyntax.handler.OperationHandler;
import core.basesyntax.handler.OperationStrategy;
import core.basesyntax.model.FruitTransaction;

import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler handler = operationStrategy.getHandler(transaction.getOperation());
            handler.apply(transaction);
        }
    }
}
