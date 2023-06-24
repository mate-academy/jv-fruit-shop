package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionHandler;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.strategy.FruitTransactionStrategy;
import java.util.List;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private final FruitTransactionStrategy fruitTransactionStrategy;

    public FruitTransactionServiceImpl() {
        fruitTransactionStrategy = new FruitTransactionStrategy();
    }

    @Override
    public void processTransactions(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            FruitTransactionHandler fruitTransactionHandler = fruitTransactionStrategy
                    .getFruitTransactionService(transaction.getOperation());

            fruitTransactionHandler.handle(transaction);
        }
    }
}
