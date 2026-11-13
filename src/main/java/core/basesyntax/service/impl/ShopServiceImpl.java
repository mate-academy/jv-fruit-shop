package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        if (operationStrategy == null) {
            throw new IllegalArgumentException(
                    "Operation strategy cannot be null");
        }
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        if (transactions == null) {
            throw new IllegalArgumentException(
                    "Transactions cannot be null");
        }

        for (FruitTransaction transaction : transactions) {
            validateTransaction(transaction);

            operationStrategy.getHandler(transaction.getOperation())
                    .handle(transaction);
        }
    }

    private void validateTransaction(FruitTransaction transaction) {
        if (transaction == null) {
            throw new IllegalArgumentException(
                    "Transaction cannot be null");
        }

        if (transaction.getOperation() == null) {
            throw new IllegalArgumentException(
                    "Operation cannot be null");
        }

        if (transaction.getFruit() == null
                || transaction.getFruit().isBlank()) {
            throw new IllegalArgumentException(
                    "Fruit cannot be null or empty");
        }

        if (transaction.getQuantity() < 0) {
            throw new IllegalArgumentException(
                    "Quantity cannot be negative");
        }
    }
}
