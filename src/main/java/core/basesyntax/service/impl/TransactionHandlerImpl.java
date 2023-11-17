package core.basesyntax.service.impl;

import core.basesyntax.model.ItemTransaction;
import core.basesyntax.service.TransactionHandler;
import core.basesyntax.strategy.DataOperationStrategy;
import core.basesyntax.strategy.impl.DataOperationStrategyImpl;
import java.util.List;

public class TransactionHandlerImpl implements TransactionHandler {
    private final DataOperationStrategy dataOperationStrategy = new DataOperationStrategyImpl();

    @Override
    public void handle(List<ItemTransaction> itemTransactions) {
        if (itemTransactions == null) {
            throw new NullPointerException("input is null");
        }
        for (ItemTransaction itemTransaction : itemTransactions) {
            dataOperationStrategy.get(itemTransaction.getOperation()).handle(itemTransaction);
        }
    }
}
