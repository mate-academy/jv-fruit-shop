package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.strategy.OperationStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> fruitTransactions) {
        fruitTransactions.forEach(fruitTransaction ->
                operationStrategy.getOperationHandler(fruitTransaction.getOperation())
                        .handle(fruitTransaction));
    }
}
