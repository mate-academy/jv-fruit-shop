package core.basesyntax.service.impl;

import core.basesyntax.database.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionService;
import core.basesyntax.strategy.OperationHandlerStrategy;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    private final OperationHandlerStrategy operationHandleStrategy;

    public TransactionServiceImpl(OperationHandlerStrategy operationHandleStrategy) {
        this.operationHandleStrategy = operationHandleStrategy;
    }

    @Override
    public void transferToStorage(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            if (FruitStorage.fruitStorage.isEmpty()
                    || !FruitStorage.fruitStorage.containsKey(transaction.getFruit())) {
                FruitStorage.fruitStorage.put(
                        transaction.getFruit(),
                        transaction.getQuantity());
            } else {
                FruitStorage.fruitStorage.put(
                            transaction.getFruit(),
                            operationHandleStrategy.get(transaction.getOperation())
                                .apply(FruitStorage.fruitStorage.get(transaction.getFruit()),
                                        transaction.getQuantity()));
            }
        }
    }
}

