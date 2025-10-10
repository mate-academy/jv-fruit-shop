package core.basesyntax.serviceimpl;

import core.basesyntax.common.FruitTransaction;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.OperationHandler;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        if (operationStrategy == null) {
            throw new RuntimeException("OperationStrategy must not be null");
        }
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        if (transactions == null) {
            throw new RuntimeException("Transactions list must not be null");
        }

        for (int i = 0; i < transactions.size(); i++) {
            FruitTransaction transaction = transactions.get(i);
            if (transaction == null) {
                throw new RuntimeException("Transaction at index " + i + " is null");
            }
            if (transaction.getOperation() == null) {
                throw new RuntimeException("Transaction operation at index " + i + " is null");
            }

            OperationHandler handler;
            try {
                handler = operationStrategy.getOperationHandler(transaction.getOperation());
            } catch (RuntimeException e) {
                throw new RuntimeException(
                        "Failed to get handler for transaction at index " + i
                                + ": " + transaction, e);
            }

            if (handler == null) {
                throw new RuntimeException(
                        "No handler found for operation " + transaction.getOperation()
                                + " at index " + i);
            }

            try {
                handler.apply(transaction);
            } catch (RuntimeException e) {
                throw new RuntimeException(
                        "Failed to apply handler for transaction at index " + i
                                + ": " + transaction, e);
            }
        }
    }
}
