package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {

        if (transactions == null) {
            throw new IllegalArgumentException("Transactions list cannot be null.");
        }

        for (FruitTransaction transaction : transactions) {
            OperationHandler handler = operationStrategy
                    .getOperationHandler(transaction.getOperation());

            if (handler == null) {
                throw new RuntimeException("No handler found for operation: "
                        + transaction.getOperation());
            }

            handler.handle(transaction);
        }
    }
}
