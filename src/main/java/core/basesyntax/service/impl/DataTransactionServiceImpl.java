package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataTransactionService;
import core.basesyntax.strategy.FruitTransactionHandler;
import core.basesyntax.strategy.FruitTransactionStrategy;
import core.basesyntax.strategy.impl.FruitTransactionStrategyImpl;
import java.util.List;

public class DataTransactionServiceImpl implements DataTransactionService {
    private final FruitTransactionStrategy fruitTransactionStrategy;

    public DataTransactionServiceImpl() {
        fruitTransactionStrategy = new FruitTransactionStrategyImpl();
    }

    @Override
    public void parseData(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction transaction : fruitTransactions) {
            FruitTransactionHandler fruitTransaction =
                    fruitTransactionStrategy.getTransaction(transaction.getOperation());
            fruitTransaction.handleTransaction(transaction);
        }
    }
}
