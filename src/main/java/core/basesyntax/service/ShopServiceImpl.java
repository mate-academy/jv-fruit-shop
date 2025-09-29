package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.OperationStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        transactions.forEach(transaction -> operationStrategy
                        .get(transaction.getOperation())
                        .apply(transaction));
    }
}
