package core.basesyntax.servise;

import core.basesyntax.FruitTransaction;
import core.basesyntax.operation.TransactionHandler;
import core.basesyntax.operation.TransactionHandlerStrategy;
import core.basesyntax.operation.TransactionHandlerStrategyImp;

import java.util.List;
import java.util.Map;

public class FruitStockUpdaterImp implements FruitStockUpdater {
    private final Map<FruitTransaction.Operation, TransactionHandler> operationMap;
    private final TransactionHandlerStrategy operationStrategy = new TransactionHandlerStrategyImp();

    public FruitStockUpdaterImp(Map<FruitTransaction.Operation, TransactionHandler> operationMap) {
        this.operationMap = operationMap;
    }

    @Override
    public void processTransactions(List<FruitTransaction> list) {
        for (FruitTransaction fruitTransaction : list) {
            operationStrategy.get(fruitTransaction.getOperation(), operationMap)
                    .applyTransaction(fruitTransaction);
        }
    }
}
