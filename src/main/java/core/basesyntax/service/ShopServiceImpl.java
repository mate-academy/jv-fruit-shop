package core.basesyntax.service;

import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.OperationStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        if (transactions == null) {
            throw new IllegalArgumentException("Transactions list cannot be null");
        }
        for (FruitTransaction transaction : transactions) {
            if (transaction == null) {
                throw new IllegalArgumentException("Transaction entry in the list cannot be null");
            }
            OperationHandler handler = operationStrategy.get(transaction.getOperation());
            handler.handle(transaction);
        }
    }
}
