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
    public void process(FruitTransaction fruitTransaction) {
        OperationHandler operationHandler =
                operationStrategy.operationHandler(fruitTransaction.getOperation());
        int balanceBefore = storage.getFruitBalance(fruitTransaction.getFruit());
        int balanceAfter = operationHandler.warehouse(balanceBefore,
                fruitTransaction.getQuantity());

        if (fruitTransaction.getOperation() == FruitTransaction.Operation.BALANCE) {
            storage.setFruitBalance(fruitTransaction.getFruit(), balanceAfter);
        } else {
            storage.updateFruitBalance(fruitTransaction.getFruit(), balanceAfter - balanceBefore);
        }
    }
}
