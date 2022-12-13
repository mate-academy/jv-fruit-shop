package core.basesyntax.services.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.FruitShopService;
import core.basesyntax.strategy.HandlerAllOperation;
import core.basesyntax.strategy.TransactionStrategy;
import core.basesyntax.strategy.impl.TransactionStrategyImpl;
import java.util.List;
import java.util.Map;

public class FruitShopServiceImpl implements FruitShopService {

    private final TransactionStrategy transactionStrategy;

    public FruitShopServiceImpl(Map<FruitTransaction.Operation,
            HandlerAllOperation> operationHandlersMap) {
        this.transactionStrategy = new TransactionStrategyImpl(operationHandlersMap);
    }

    @Override
    public void execute(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction transaction : fruitTransactions) {
            transactionStrategy.get(transaction.getOperation()).handlerAllOperation(transaction);
        }
    }
}
