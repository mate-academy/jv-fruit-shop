package core.basesyntax.service;

import core.basesyntax.service.model.FruitTransaction;
import core.basesyntax.service.operation.OperationHandler;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler handler = operationStrategy.get(transaction.getOperation());
            if (handler != null) {
                handler.apply(transaction);
            } else {
                throw new IllegalArgumentException("Unknown operation: "
                        + transaction.getOperation());
            }

        }
    }

}
