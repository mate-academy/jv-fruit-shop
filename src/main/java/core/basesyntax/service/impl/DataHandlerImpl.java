package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataHandler;
import core.basesyntax.strategy.TransactionStrategy;
import java.util.List;

public class DataHandlerImpl implements DataHandler {
    private final TransactionStrategy strategy;

    public DataHandlerImpl(TransactionStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void processTransaction(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            strategy.get(transaction.getOperation()).handleTransaction(transaction);
        }
    }
}
