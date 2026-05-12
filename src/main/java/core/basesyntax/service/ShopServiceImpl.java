package core.basesyntax.service;

import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.transaction.FruitTransaction;
import core.basesyntax.transaction.Transaction;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;
    private final Transaction transaction;

    public ShopServiceImpl(OperationStrategy operationStrategy, Transaction transaction) {
        this.operationStrategy = operationStrategy;
        this.transaction = transaction;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction ft : transactions) {
            operationStrategy.get(ft.getOperation()).handle(ft, transaction);
        }
    }
}
