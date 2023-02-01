package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.operation.OperationHandler;
import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {
    @Override
    public void processTransactions(List<FruitTransaction> fruitTransactionsList,
                                    OperationStrategy operationStrategy) {
        for (FruitTransaction transaction : fruitTransactionsList) {
            OperationHandler handler = operationStrategy
                    .get(transaction.getOperation());
            handler.updateAmount(transaction);
        }
    }
}
