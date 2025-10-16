package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationHandler;
import java.util.List;
import java.util.Objects;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = Objects.requireNonNull(
                operationStrategy,
                "operationStrategy must not be null");
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        Objects.requireNonNull(transactions,
                "transactions must not be null");
        int index = 0;
        for (FruitTransaction transaction : transactions) {
            index++;
            if (transaction == null) {
                throw new IllegalArgumentException("Transaction at index "
                        + index + " is null");
            }
            if (transaction.getOperation() == null) {
                throw new IllegalArgumentException(
                        "Operation at transaction index "
                                + index + " is null");
            }
            OperationHandler handler = operationStrategy.get(
                    transaction.getOperation());
            handler.handle(transaction);
        }
    }
}
