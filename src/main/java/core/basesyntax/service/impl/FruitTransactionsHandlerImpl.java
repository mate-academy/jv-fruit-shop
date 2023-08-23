package core.basesyntax.service.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class FruitTransactionsHandlerImpl implements FruitTransactionHandler {
    private final FruitStorage fruitStorage;
    private OperationStrategy operationStrategy;

    public FruitTransactionsHandlerImpl(FruitStorage fruitStorage,
                                        OperationStrategy operationStrategy) {
        this.fruitStorage = fruitStorage;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void processTransactionsList(List<FruitTransaction> fruitTransactionList) {
        fruitTransactionList.forEach(transaction -> {
            OperationHandler operationHandler = operationStrategy
                    .getHandler(transaction.getOperation());
            fruitStorage.updateFruitQuantity(transaction.getFruit(),
                    operationHandler.getFruitAmount(transaction.getQuantity()));
        });
    }
}
