package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.OperationStrategy;
import core.basesyntax.service.strategy.operations.OperationHandler;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        if (transactions == null) {
            throw new RuntimeException("The transactions list is empty.");
        }
        for (FruitTransaction transaction : transactions) {
            if (transaction.getQuantity() < 0) {
                throw new RuntimeException("The quantity of operation can't be negative!");
            }
            OperationHandler handler = operationStrategy.get(transaction.getOperation());
            handler.apply(transaction);
        }
    }
}
