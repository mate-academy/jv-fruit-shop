package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.FruitOperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void processFruitTransactions(List<FruitTransaction> fruitTransactions,
                                         Map<String, Integer> inventory) {
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            FruitOperationHandler handler =
                    operationStrategy.getHandler(fruitTransaction.getOperation());
            if (handler != null) {
                handler.executeOperation(fruitTransaction, inventory);
            } else {
                throw new IllegalArgumentException("No handler for operation: "
                        + fruitTransaction.getOperation());
            }
        }
    }
}
