package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
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
            throw new RuntimeException("Transactions can't be null");
        }

        for (FruitTransaction transaction : transactions) {
            if (transaction == null) {
                throw new RuntimeException("Transaction can't be null");
            }

            operationStrategy.get(transaction.getOperation())
                    .handle(transaction);
        }
    }
}
