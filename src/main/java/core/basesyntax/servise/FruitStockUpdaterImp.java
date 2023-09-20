package core.basesyntax.servise;

import core.basesyntax.FruitTransaction;
import core.basesyntax.operation.TransactionHandlerStrategy;
import java.util.List;

public class FruitStockUpdaterImp implements FruitStockUpdater {
    private final TransactionHandlerStrategy operationStrategy;

    public FruitStockUpdaterImp(TransactionHandlerStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void processTransactions(List<FruitTransaction> list) {
        for (FruitTransaction fruitTransaction : list) {
            operationStrategy.get(fruitTransaction.getOperation())
                    .applyTransaction(fruitTransaction);
        }
    }
}
