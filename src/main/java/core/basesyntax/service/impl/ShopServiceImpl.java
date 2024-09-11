package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.impl.operation.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        if (transactions == null || transactions.isEmpty()) {
            throw new IllegalArgumentException("Transaction list can't be null or empty");
        }
        for (FruitTransaction fruitTransaction : transactions) {
            Fruit fruit = fruitTransaction.getFruit();
            int quantity = fruitTransaction.getQuantity();
            OperationHandler operationHandler = operationStrategy
                    .getHandler(fruitTransaction.getOperation());
            operationHandler.applyOperation(fruit, quantity);
        }
    }
}
