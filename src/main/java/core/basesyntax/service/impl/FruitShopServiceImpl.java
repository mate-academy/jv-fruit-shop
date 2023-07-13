package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.handler.OperationHandler;
import core.basesyntax.strategy.TransactionStrategy;
import core.basesyntax.strategy.impl.TransactionStrategyImpl;
import java.util.List;
import java.util.Map;

public class FruitShopServiceImpl implements FruitShopService {
    private final TransactionStrategy transactionStrategy;

    public FruitShopServiceImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationHandlersMap) {
        this.transactionStrategy = new TransactionStrategyImpl(operationHandlersMap);
    }

    @Override
    public void transfer(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction transaction : fruitTransactions) {
            transactionStrategy.get(transaction.getOperation()).processOperation(transaction);
        }
    }
}
