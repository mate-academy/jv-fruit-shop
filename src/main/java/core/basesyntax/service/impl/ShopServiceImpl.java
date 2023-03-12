package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.TransactionHandler;
import core.basesyntax.strategy.TransactionStrategy;
import core.basesyntax.strategy.impl.TransactionStrategyImpl;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private final TransactionStrategy transactionStrategy;

    public ShopServiceImpl(Map<FruitTransaction.Operation,
            TransactionHandler> operationHandlerMap) {
        this.transactionStrategy = new TransactionStrategyImpl(operationHandlerMap);
    }

    @Override
    public void processData(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            transactionStrategy.get(transaction.getOperation()).executeTransaction(transaction);
        }
    }
}
