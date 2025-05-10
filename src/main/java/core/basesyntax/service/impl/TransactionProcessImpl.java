package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionProcess;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;

public class TransactionProcessImpl implements TransactionProcess {
    private final Storage storage;
    private final OperationStrategy operationStrategy;

    public TransactionProcessImpl(OperationStrategy operationStrategy, Storage storage) {
        this.storage = storage;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(FruitTransaction transaction) {
        OperationHandler handler = operationStrategy.operationHandler(transaction.getOperation());
        handler.warehouse(transaction);
    }
}
