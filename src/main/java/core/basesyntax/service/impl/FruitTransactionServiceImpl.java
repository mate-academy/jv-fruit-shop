package core.basesyntax.service.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private final OperationStrategy operationStrategy;

    public FruitTransactionServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void addToStorage(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            if (!FruitStorage.fruitStorage.containsKey(transaction.getFruit())) {
                FruitStorage.fruitStorage.put(transaction.getFruit(),
                        transaction.getAmount());
            } else {
                FruitStorage.fruitStorage.put(transaction.getFruit(),
                        operationStrategy.get(transaction.getOperation())
                                .apply(FruitStorage.fruitStorage.get(transaction.getFruit()),
                                        transaction.getAmount()));
            }
        }
    }
}
