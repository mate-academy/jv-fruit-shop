package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.operation.OperationHandler;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactionList) {
        for (FruitTransaction fruitTransaction : transactionList) {
            OperationHandler operationHandler =
                    operationStrategy.get(fruitTransaction.getOperation());
            operationHandler.transaction(fruitTransaction);
        }
    }
}
