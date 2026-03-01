package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        if (transactions == null || transactions.isEmpty()) {
            throw new RuntimeException("Transactions list must be not empty");
        }
        for (FruitTransaction transaction : transactions) {
            if (transaction == null) {
                throw new RuntimeException("Transaction must be not empty");
            }
            operationStrategy.getOperationHandler(transaction.getOperation()).handle(transaction);
        }
    }
}
