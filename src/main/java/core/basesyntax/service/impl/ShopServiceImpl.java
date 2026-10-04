package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.stratagy.OperationHandler;
import core.basesyntax.stratagy.OperationStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy strategy;

    public ShopServiceImpl(final OperationStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void process(final List<FruitTransaction> fruitTransactions) {
        fruitTransactions
                .forEach(transaction -> {
                    FruitTransaction.Operation operation = transaction.getOperation();
                    OperationHandler handler = strategy.getOperationHandler(operation);
                    handler.handle(transaction);

                });
    }
}
