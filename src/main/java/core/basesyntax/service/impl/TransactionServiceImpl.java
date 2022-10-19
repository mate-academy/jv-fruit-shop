package core.basesyntax.service.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionService;
import core.basesyntax.strategy.HandlerOperationStrategy;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    private final HandlerOperationStrategy operationHandlerStrategy;

    public TransactionServiceImpl(HandlerOperationStrategy operationHandlerStrategy) {
        this.operationHandlerStrategy = operationHandlerStrategy;
    }

    @Override
    public void addTransferToStorage(List<FruitTransaction> transactions) {
        FruitTransaction transaction;
        for (FruitTransaction fruitTransaction : transactions) {
            transaction = fruitTransaction;
            if (!FruitStorage.fruitStorage.containsKey(transaction.getFruit())) {
                FruitStorage.fruitStorage.put(
                        transaction.getFruit(),
                        transaction.getCount());
            } else {
                FruitStorage.fruitStorage.put(
                            transaction.getFruit(),
                            operationHandlerStrategy.get(transaction.getOperation())
                                    .apply(FruitStorage.fruitStorage.get(transaction.getFruit()),
                                            transaction.getCount()));
            }
        }
    }
}
