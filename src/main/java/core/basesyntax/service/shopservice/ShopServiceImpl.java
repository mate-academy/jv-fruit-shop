package core.basesyntax.service.shopservice;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.OperationHandler;
import core.basesyntax.service.strategy.OperationStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction transaction : fruitTransactions) {
            OperationHandler operationHandler = operationStrategy
                    .getOperation(transaction.getOperation());
            operationHandler.handle(transaction);
        }
    }
}
