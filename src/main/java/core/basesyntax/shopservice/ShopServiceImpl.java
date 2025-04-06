package core.basesyntax.shopservice;

import core.basesyntax.FruitTransaction;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.operation.OperationStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            FruitTransaction.Operation operation = transaction.getOperation();
            OperationHandler handler = operationStrategy.getHandler(operation);

            if (handler != null) {
                handler.apply(transaction);
            } else {
                throw new IllegalArgumentException("No handler found for operation: " + operation);
            }
        }
    }
}
