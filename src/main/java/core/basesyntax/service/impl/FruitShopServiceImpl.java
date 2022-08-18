package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.strategy.OperationStratategy;
import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {
    private final OperationStratategy operationStrategy;

    public FruitShopServiceImpl(OperationStratategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler operationHandler = operationStrategy.get(transaction.getOperation());
            operationHandler.handle(transaction);
        }
    }
}
