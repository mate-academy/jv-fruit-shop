package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.operation.OperationHandler;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        OperationHandler operationHandler;
        for (FruitTransaction transaction : transactions) {
            operationHandler = operationStrategy.getHandler(transaction.getOperation());
            if (operationHandler != null) {
                operationHandler.apply(transaction);
            } else {
                throw new RuntimeException("Error! Operation not found! "
                        + transaction.getOperation());
            }
        }
    }
}
