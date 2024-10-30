package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.OperationHandler;
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
            if (transaction.getQuantity() < 0) {
                throw new IllegalArgumentException(
                        "Transaction quantity cannot be negative for fruit: "
                                + transaction.getFruit());
            }
            OperationHandler handler = operationStrategy.getHandler(transaction.getOperation());
            handler.apply(transaction);
        }
    }
}
