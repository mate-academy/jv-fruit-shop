package core.basesyntax.service;

import core.basesyntax.handler.OperationHandler;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {

    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> fruitTransactionList) {
        for (FruitTransaction transaction : fruitTransactionList) {
            OperationHandler handler = operationStrategy.getOperation(transaction.getOperation());
            if (handler == null) {
                throw new RuntimeException("No handler found for operation: "
                        + transaction.getOperation());
            }
            handler.get(transaction);
        }
    }
}
