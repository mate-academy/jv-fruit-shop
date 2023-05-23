package core.basesyntax.service.impl;

import core.basesyntax.service.TransferToDb;
import core.basesyntax.strategy.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class TransferToDbImpl implements TransferToDb {
    private final OperationStrategy operationStrategy;

    public TransferToDbImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void transfer(List<FruitTransaction> transactions) {
        transactions.forEach(t -> operationStrategy.get(t.getOperation()).operate(t));
    }
}
