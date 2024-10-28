package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.stategy.FruitOperationHandler;
import core.basesyntax.stategy.OperationStrategy;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void processTransaction(List<FruitTransaction> fruitTransactions,
                                   Map<String, Integer> inventory) {
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            FruitOperationHandler handler =
                    operationStrategy.getHandler(fruitTransaction.getOperation());
            handler.executeOperation(fruitTransaction, inventory);
        }
    }
}
