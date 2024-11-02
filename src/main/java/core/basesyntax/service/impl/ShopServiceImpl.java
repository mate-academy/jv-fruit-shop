package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.impl.operation.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler handler =
                    operationStrategy.getOperationHandler(transaction.getOperation());

            if (handler == null) {
                throw new IllegalArgumentException(
                        "No handler found for operation: " + transaction.getOperation()
                );
            }

            handler.doOperation(transaction.getFruit(), transaction.getQuantity());
        }
    }
}
